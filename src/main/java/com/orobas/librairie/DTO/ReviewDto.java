package com.orobas.librairie.DTO;

import com.orobas.librairie.Entity.Book;
import com.orobas.librairie.Entity.User;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.orobas.librairie.Entity.Review}
 */
@Value
@Builder
@Getter
@Setter
@AllArgsConstructor
public class ReviewDto implements Serializable {
    Integer id;
    //Book book;
    User user;
    String review;
    Integer rating;
}