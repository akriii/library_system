package com.akri.book_inventory.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akri.book_inventory.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByUserId(Long id);
    // Spring Data JPA will generate CRUD operations automatically

    List<Book> findByBorrowed_User_Id(Long id);
}

