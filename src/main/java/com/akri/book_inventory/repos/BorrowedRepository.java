package com.akri.book_inventory.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akri.book_inventory.model.Borrowed;

@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {
}
