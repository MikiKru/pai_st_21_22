package pl.edu.pbs.pai_lect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.pai_lect.model.entities.Role;
import pl.edu.pbs.pai_lect.model.entities.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
