package com.upgrad.HireWheelsRev.service;

import com.upgrad.HireWheelsRev.entity.UserRole;
import com.upgrad.HireWheelsRev.exception.UserRoleNotFoundException;

public interface UserRoleService {
    UserRole acceptUserRoleDetails(UserRole userRole);
    UserRole findUserRoleDetails(int userRoleId) throws UserRoleNotFoundException;
}
