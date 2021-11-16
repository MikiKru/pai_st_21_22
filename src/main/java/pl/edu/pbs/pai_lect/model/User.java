package pl.edu.pbs.pai_lect.model;

import lombok.*;

import java.time.LocalDateTime;

// klasa modelu - determinuje strukturę danych
// model java beans
//@Getter
//@Setter
//@ToString
@Data               // automatycznie dodaje gettery settery i toString do klasy
@NoArgsConstructor  // automatycznie dodaje domyślny konstruktor
@AllArgsConstructor // automatycznie dodaje konstruktor z wszystkimi polami w argumentach
public class User {
    private String email;
    private String password;
    private LocalDateTime regstrationDateTime;
    private boolean status;
}
