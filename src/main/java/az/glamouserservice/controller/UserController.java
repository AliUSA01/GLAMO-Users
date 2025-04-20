package az.glamouserservice.controller;

import az.glamouserservice.dao.repository.UserRepository;
import az.glamouserservice.model.request.UserRequest;
import az.glamouserservice.model.response.UserResponse;
import az.glamouserservice.service.abstraction.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid UserRequest userRequest){
        userService.createUser(userRequest);
    }


    @GetMapping("{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    @PutMapping("{id}")
    public void updateUser(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest){
        userService.updateUser(id, userRequest);
    }



    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id
        );
    }
}
