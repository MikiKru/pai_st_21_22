package pl.edu.pbs.pai_lect.service;

import org.springframework.stereotype.Service;
import pl.edu.pbs.pai_lect.model.dtos.UserDto;
import pl.edu.pbs.pai_lect.model.entities.User;
import pl.edu.pbs.pai_lect.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public User registerUser(UserDto userDto){
        if(UserRepository.users.stream().allMatch(user -> !user.getEmail().equals(userDto.getEmail()))) {
            User user = new User();
            UserRepository.users.add(user);
            return user;
        }
        return new User();
    }
    public List<User> getAllUsers(){
        return UserRepository.users;
    }
    public Optional<User> getUserByEmail(String email){
        return UserRepository.users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
    public boolean updateUserStatusByEmail(String email){
        Optional<User> userOptional = getUserByEmail(email);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setStatus(!user.isStatus());
            return true;
        }
        return false;
    }
    public boolean deleteUserByEmail(String email){
//        Optional<User> userOptional = getUserByEmail(email);
//        if(userOptional.isPresent()){
//            User user = userOptional.get();
//            return UserRepository.users.remove(user);
//        }
//        return false;
        return UserRepository.users.remove(getUserByEmail(email).orElse(new User()));
    }

}
