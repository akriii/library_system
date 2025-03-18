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
    private String userPassword; // Renamed for Java conventions

    @Column(name = "USER_EMAIL", nullable = false)
    private String userEmail; // Renamed for Java conventions

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Borrowed> borrowed;

    public User() {}

    public User(String userEmail, String userPassword, List<Borrowed> borrowed) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.borrowed = borrowed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Borrowed> getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(List<Borrowed> borrowed) {
        this.borrowed = borrowed;
    }
}
