package com.upgrad.HireWheelsRev.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int amount;

    @ManyToOne
    User user;
}
