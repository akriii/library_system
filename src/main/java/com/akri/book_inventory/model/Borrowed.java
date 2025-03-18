package com.akri.book_inventory.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BORROWED")
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BORROWED_ID")
    private long borrowedId;

    @Column(name = "BORROWED_DATE", nullable = false)
    private Date borrowedDate;

    @Column(name = "BORROWED_DAY_COUNT", nullable = false)
    private int dayCount;

    @Column(name = "BORROWED_BOOKS_QTY", nullable = false)
    private int booksQty;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private Book book;

    public Borrowed() {}

    public Borrowed(Date borrowedDate, int dayCount, int booksQty, User user, Book book) {
        this.borrowedDate = borrowedDate;
        this.dayCount = dayCount;
        this.booksQty = booksQty;
        this.user = user;
        this.book = book;
    }

    public long getBorrowedId() {
        return borrowedId;
    }

    public void setBorrowedId(long borrowedId) {
        this.borrowedId = borrowedId;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public int getBooksQty() {
        return booksQty;
    }

    public void setBooksQty(int booksQty) {
        this.booksQty = booksQty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
