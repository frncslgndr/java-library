package com.orobas.librairie.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowGetDTO implements Serializable {
    private Integer id;
    private Integer book_id;
    private Integer user_id;
    private LocalDate startAt;
    private LocalDate shouldReturnAt;
    private LocalDate endAt;
    private String startCondition;
    private String endCondition;
    private Integer cost;
}
