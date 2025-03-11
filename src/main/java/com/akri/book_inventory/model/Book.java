package com.akri.book_inventory.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FILES")
public class Book {
    @Id
    @Column(name = "FILE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FILE_NAME")
    private String name;
    @Column(name = "FILE_AUTHOR")
    private String author;
    @Column(name = "FILE_GENRE")
    private String genre;
    @Column(name = "UPLOADED_AT")
    private LocalTime upload_time;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    
    public Book(){}

    public Book(Long id, String name, String author, String genre, LocalTime upload_time, User user) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.upload_time = upload_time;
        this.user = user;
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



    public LocalTime getUpload_time() {
        return upload_time;
    }



    public void setUpload_time(LocalTime upload_time) {
        this.upload_time = upload_time;
    }



    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }



    
    
    
   

    
    
}
