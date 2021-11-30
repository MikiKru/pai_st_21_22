package pl.edu.pbs.pai_lect.repository;

import pl.edu.pbs.pai_lect.model.entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserRepository {
    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User(
                            "a@a.pl",
                            "a",
                            LocalDateTime.of(2020, 5, 3, 10, 10),
                            true),
                    new User("" +
                            "b@b.pl",
                            "bb",
                            LocalDateTime.of(2021, 1, 30, 11, 10),
                            true),
                    new User(
                            "c@c.pl",
                            "c",
                            LocalDateTime.of(2020, 5, 3, 10, 10),
                            true)
            )
    );
}
