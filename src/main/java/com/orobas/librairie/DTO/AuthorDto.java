package com.orobas.librairie.DTO;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.orobas.librairie.Entity.Author}
 */
@Value
public class AuthorDto implements Serializable {
    Integer id;
    String firstname;
    String lastname;
    LocalDate birthdate;
    LocalDate deathdate;
}