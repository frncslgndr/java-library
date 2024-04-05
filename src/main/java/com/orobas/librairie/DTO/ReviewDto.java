package com.orobas.librairie.DTO;

import com.orobas.librairie.Entity.Book;
import com.orobas.librairie.Entity.User;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.orobas.librairie.Entity.Review}
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto implements Serializable {
    private Integer id;
    // private Book book;
    private User user;
    private String review;
    private Integer rating;
}