package com.orobas.librairie.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "literary_genre")
public class LiteraryGenre {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "genre", nullable = false)
    private String genre;

    public LiteraryGenre() {

    }
}