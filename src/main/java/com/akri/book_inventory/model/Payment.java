package com.akri.book_inventory.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @Column(name = "PAYMENT_ID", length = 10, nullable = false, unique = true)
    private String id;

    @Column(name = "PAYMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "PAYMENT_AMOUNT", precision = 10, scale = 2)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "BORROWED_ID", nullable = false)
    private Borrowed borrowed;

    public Payment() {}

    public Payment(String id, Date paymentDate, BigDecimal amount, Borrowed borrowed) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.borrowed = borrowed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Borrowed getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Borrowed borrowed) {
        this.borrowed = borrowed;
    }
}
