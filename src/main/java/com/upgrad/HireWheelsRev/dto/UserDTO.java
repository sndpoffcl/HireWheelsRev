package com.upgrad.HireWheelsRev.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.upgrad.HireWheelsRev.entity.Booking;
import com.upgrad.HireWheelsRev.entity.UserRole;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class UserDTO {
    int userId;
    String firstName;
    String lastName;
    String email;
    String password;
    String mobile;
    int walletMoney;
    int userRoleId;
    List<Integer> bookingIds;

}
