package pl.edu.pbs.pai_lect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.pai_lect.model.entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

}
