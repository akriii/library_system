package com.akri.book_inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADMINISTRATOR")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADMIN_ID")
    private long id;

    @Column(name = "ADMIN_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "ADMIN_PASSWORD", nullable = false)
    private String password;

    @Column(name = "ADMIN_NAME", nullable = false)
    private String name;

    @Column(name = "ADMIN_PHNO", nullable = false)
    private String phone;

    // Uncomment if you want an admin to manage multiple books
    // @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Book> books;

    public Administrator() {}

    public Administrator(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
