package com.orobas.librairie.Repository;

import com.orobas.librairie.Entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    List<Borrow> findAllByBookId(Integer book_id);

    List<Borrow> findAllByUserId(Integer user_id);

}