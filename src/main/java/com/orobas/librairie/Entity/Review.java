package com.orobas.librairie.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Lob
    @Size(min = 15, max = 420, message = "Votre message doit contenir entre {min} et {max} caractères." )
    @Column(name = "content", nullable = false)
    private String content;

    @Min(value = 1,  message = "Note minimale : {value}")
    @Max(value = 10, message = "Note maximale : {value}")
    @Column(name = "rating", nullable = false)
    private Integer rating;

}