package az.glamouserservice.service.concrete;

import az.glamouserservice.dao.entity.UserEntity;
import az.glamouserservice.dao.repository.UserRepository;
import az.glamouserservice.exception.NotFoundException;
import az.glamouserservice.exception.ResourceNotFoundException;
import az.glamouserservice.model.request.UserRequest;
import az.glamouserservice.model.response.UserResponse;
import az.glamouserservice.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.glamouserservice.mapper.UserMapper.USER_MAPPER;
import static az.glamouserservice.model.enums.ErrorMessage.USER_NOT_FOUND;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserServiceHandler implements UserService {
    private final UserRepository userRepository;

    @Override
    public void createUser(UserRequest userRequest) {
        var user = USER_MAPPER.buildUserEntity(userRequest);

        // 🚫 Password encoding removed
        user.setPassword(userRequest.getPassword());

        userRepository.save(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userRepository.findById(id)
                .map(USER_MAPPER::buildUserResponse)
                .orElseThrow(() ->
                        new NotFoundException(format(USER_NOT_FOUND.getMessage(), id)));
    }

    @Override
    public void updateUser(Long id, UserRequest request) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(USER_NOT_FOUND.getMessage())));

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        // 🚫 Password encoding removed
        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(request.getPassword());
        }

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(format(USER_NOT_FOUND.getMessage(), id)));

        userRepository.delete(user);
    }
}
