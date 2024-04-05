package com.orobas.librairie.Repository;

import com.orobas.librairie.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByBook_Title(String title);
}