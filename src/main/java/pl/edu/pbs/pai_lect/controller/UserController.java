package pl.edu.pbs.pai_lect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pbs.pai_lect.model.User;
import pl.edu.pbs.pai_lect.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")        // mapowanie żądania GET posiadający w ścieżce fragment /
    public String helloString(){
        return "hello Spring!";
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/users")
    public User registerUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        return userService.registerUser(email, password);
    }

}
