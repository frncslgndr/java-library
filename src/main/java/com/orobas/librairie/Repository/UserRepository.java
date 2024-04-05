package com.orobas.librairie.Repository;

import com.orobas.librairie.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}