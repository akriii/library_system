package com.akri.book_inventory.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akri.book_inventory.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA will generate CRUD operations automatically
}


