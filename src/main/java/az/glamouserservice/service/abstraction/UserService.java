package az.glamouserservice.service.abstraction;

import az.glamouserservice.model.request.UserRequest;
import az.glamouserservice.model.response.UserResponse;

public interface UserService {
     void createUser(UserRequest userRequest);

     UserResponse getUserById(Long id);

     void updateUser(Long id, UserRequest userRequest);

     void deleteUser(Long id);



}
