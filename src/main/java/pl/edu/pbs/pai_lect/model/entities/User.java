package pl.edu.pbs.pai_lect.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

// klasa modelu - determinuje strukturę danych
// model java beans
//@Getter
//@Setter
//@ToString
@Entity
@Data               // automatycznie dodaje gettery settery i toString do klasy
@NoArgsConstructor  // automatycznie dodaje domyślny konstruktor
@AllArgsConstructor // automatycznie dodaje konstruktor z wszystkimi polami w argumentach
public class User {
    @Id                                                     // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto_incement
    private int user_id;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime;
    private boolean status;
    @JsonIgnore
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_to_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
