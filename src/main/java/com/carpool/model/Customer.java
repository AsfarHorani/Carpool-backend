package com.carpool.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "walletId", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private UserDao wallet;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;
    public long getId() {
        return id;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDao getWallet() {
        return wallet;
    }

    public void setWallet(UserDao wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", wallet=" + wallet + "]";
    }
    
    
    
    
}
