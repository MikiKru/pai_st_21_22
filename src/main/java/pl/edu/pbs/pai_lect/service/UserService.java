package pl.edu.pbs.pai_lect.service;

import org.springframework.stereotype.Service;
import pl.edu.pbs.pai_lect.model.User;
import pl.edu.pbs.pai_lect.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    public User registerUser(String email, String password){
        User user = new User(email, password, LocalDateTime.now(), false);
        UserRepository.users.add(user);
        return user;
    }
    public List<User> getAllUsers(){
        return UserRepository.users;
    }
}
