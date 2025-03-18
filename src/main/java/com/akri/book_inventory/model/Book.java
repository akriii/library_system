package com.akri.book_inventory.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "BOOK_NAME", nullable = false)
    private String name;

    @Column(name = "BOOK_AUTHOR", nullable = false)
    private String author;

    @Column(name = "BOOK_GENRE", nullable = false)
    private String genre;

    @Column(name = "BOOK_COPIES", nullable = false)
    private int copies;

    @Column(name = "PRICE_PER_DAY", nullable = false)
    private double pricePerDay;

    @ManyToOne
    @JoinColumn(name = "ADMIN_ID", nullable = false)
    private Administrator admin;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Borrowed> borrowed;

    public Book() {}

    public Book(String name, String author, String genre, int copies, double pricePerDay, Administrator admin, List<Borrowed> borrowed) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.copies = copies;
        this.pricePerDay = pricePerDay;
        this.admin = admin;
        this.borrowed = borrowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public List<Borrowed> getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(List<Borrowed> borrowed) {
        this.borrowed = borrowed;
    }
}
