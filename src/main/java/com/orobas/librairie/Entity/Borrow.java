package com.orobas.librairie.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, insertable=false, updatable=false)
    private User user;

    @Column(name = "book_id")
    private Integer book_id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false, insertable=false, updatable=false)
    private Book book;

    @NotNull
    @Column(name = "start_at", nullable = false)
    private LocalDate startAt;

    @NotNull
    @Column(name = "should_return_at", nullable = false)
    private LocalDate shouldReturnAt;

    @Column(name = "return_at")
    private LocalDate returnAt;

    @Size(max = 50)
    @NotNull
    @Column(name = "start_condition", nullable = false, length = 50)
    private String startCondition;

    @Size(max = 50)
    @Column(name = "end_condition", length = 50)
    private String endCondition;

    @Column(name = "cost")
    private Integer cost;

}