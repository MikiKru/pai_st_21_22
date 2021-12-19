package pl.edu.pbs.pai_lect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pbs.pai_lect.model.dtos.UserDto;
import pl.edu.pbs.pai_lect.model.entities.Role;
import pl.edu.pbs.pai_lect.model.entities.User;
import pl.edu.pbs.pai_lect.repository.RoleRepository;
import pl.edu.pbs.pai_lect.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User registerUser(UserDto userDto){
        Optional<User> userOptional = getUserByEmail(userDto.getEmail());
        if(!userOptional.isPresent()) {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setStatus(true);
            user.setRegistrationDateTime(LocalDateTime.now());
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.getById(2));
            user.setRoles(roles);
            return userRepository.save(user);   // zapis użytkownika do tabeli user
        }
        return new User();
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserByEmail(String email){
        return userRepository.findFirstByEmail(email);
    }
    public boolean updateUserStatusByEmail(String email){
        Optional<User> userOptional = getUserByEmail(email);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setStatus(!user.isStatus());
            userRepository.save(user);          // update - gdy wykonywany jest na istniejącym obiekcie w tabeli db
            return true;
        }
        return false;
    }
    public boolean deleteUserByEmail(String email){
        Optional<User> userOptional = getUserByEmail(email);
        if(userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return true;
        }
        return false;
    }

}
