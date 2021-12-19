package pl.edu.pbs.pai_lect.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pbs.pai_lect.model.enums.RoleName;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;
}
