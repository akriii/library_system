package com.akri.book_inventory.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String user_password;

    @Column(name = "USER_EMAIL",nullable = false)
    private String user_email;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)




    private List<Book> books;

    public User(){}
    
    public User(long id, String user_password, String user_email, List<Book> books) {
        this.id = id;
        this.user_password = user_password;
        this.user_email = user_email;
        this.books = books;
    }

    public long getUser_id() {
        return id;
    }

    public void setUser_id(long id) {
        this.id = id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    

    
   


    

}
