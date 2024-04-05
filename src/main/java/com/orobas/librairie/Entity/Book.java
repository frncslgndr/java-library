package com.orobas.librairie.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "book")
public class Book {
    public static Map<String, Integer> conditions = Map.of("Neuf", 100, "Très bon", 70, "Bon", 50, "Usé", 20, "Très usé", 10);

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "`desc`", nullable = false)
    private String desc;

    @Column(name = "nb_page", nullable = false)
    private Integer nbPage;

    @Column(name = "author_id", nullable = false)
    private Integer author_id;

    @Column(name = "genre_id", nullable = false)
    private Integer genre_id;

    @Column(name = "value")
    private Integer value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false )
    @JoinColumn(name = "author_id", nullable = false, updatable = false, insertable = false)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genre_id", nullable = false, updatable = false, insertable = false)
    private LiteraryGenre genre;


    public Book() {

    }
}