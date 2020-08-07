package com.upgrad.HireWheelsRev.dao;

import com.upgrad.HireWheelsRev.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRoleDAO")
public interface UserRoleDAO extends JpaRepository<UserRole , Integer> {
    UserRole findByUserRoleName(String userRole);
}
