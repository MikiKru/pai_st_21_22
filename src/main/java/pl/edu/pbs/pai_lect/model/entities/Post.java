package pl.edu.pbs.pai_lect.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import pl.edu.pbs.pai_lect.model.enums.Category;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    private String title;
    @Type(type = "text")
    private String content;
    @Enumerated(value = EnumType.ORDINAL)
    private Category category;
    private LocalDateTime dateAdded;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

}
