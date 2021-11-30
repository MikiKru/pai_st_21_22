package pl.edu.pbs.pai_lect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pbs.pai_lect.model.dtos.UserDto;
import pl.edu.pbs.pai_lect.model.entities.User;
import pl.edu.pbs.pai_lect.service.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers().stream()
                .sorted(Comparator.comparing(User::getRegstrationDateTime).reversed())
                .collect(Collectors.toList());
    }
    @GetMapping("/users/{user_email}")
    public User getUserByEmail(@PathVariable("user_email") String email){
        return userService.getUserByEmail(email).orElse(new User());
    }
    @PostMapping("/users")
    public User registerUser(
//            @RequestParam("email") String email,
//            @RequestParam("password") String password
            UserDto userDto
            ){
        return userService.registerUser(userDto);
    }
    @PutMapping("/users/{user_email}")
    public boolean updateUserStatusByUserEmail(@PathVariable("user_email") String email){
        return userService.updateUserStatusByEmail(email);
    }
    @DeleteMapping("/users/{user_email}")
    public boolean deleteUserByEmail(@PathVariable("user_email") String email){
        return userService.deleteUserByEmail(email);
    }

}
