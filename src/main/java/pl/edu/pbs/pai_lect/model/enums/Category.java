package pl.edu.pbs.pai_lect.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    IT("programowanie"),
    TEST("testowanie"),
    DEV_OPS("administracja");

    private final String categoryName;


}
