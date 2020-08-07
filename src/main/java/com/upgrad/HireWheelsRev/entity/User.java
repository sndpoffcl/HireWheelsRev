package com.upgrad.HireWheelsRev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(nullable = false)
    String firstName;

    String lastName;

    @Column(nullable = false , unique = true)
    String email;

    @Column(nullable = false)
    String password;

    @Column(nullable = false , unique = true)
    String mobile;

    int walletMoney;

    @ManyToOne
    @JsonBackReference
    UserRole userRole;

    @OneToMany(mappedBy = "user")
    List<Booking> bookings;

}
