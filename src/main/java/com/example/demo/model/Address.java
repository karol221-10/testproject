package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity(name="address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="town")
    private String town;
    @Column(name="street")
    private String street;
    @Column(name="house_number")
    private String houseNumber;
    @ManyToOne
    @JoinColumn(name="userAddr")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}