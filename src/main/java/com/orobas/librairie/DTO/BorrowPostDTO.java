package com.orobas.librairie.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Value
@Builder
@Getter
@Setter
@AllArgsConstructor
public class BorrowPostDTO implements Serializable {
    Integer book_id;
    Integer user_id;
    LocalDate startAt;
    LocalDate shouldReturnAt;
    String startCondition;
}
