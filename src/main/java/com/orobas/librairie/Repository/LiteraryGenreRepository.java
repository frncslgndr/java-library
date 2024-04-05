package com.orobas.librairie.Repository;

import com.orobas.librairie.Entity.LiteraryGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiteraryGenreRepository extends JpaRepository<LiteraryGenre, Integer> {
}