package com.orobas.librairie.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Value
@Builder
@Getter
@Setter
@AllArgsConstructor
public class BorrowPutDTO implements Serializable {
    LocalDate returnAt;
    String endCondition;
}
