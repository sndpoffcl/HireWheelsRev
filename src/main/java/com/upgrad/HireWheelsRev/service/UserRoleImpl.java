package com.upgrad.HireWheelsRev.service;

import com.upgrad.HireWheelsRev.dao.UserRoleDAO;
import com.upgrad.HireWheelsRev.entity.UserRole;
import com.upgrad.HireWheelsRev.exception.UserRoleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleImpl implements UserRoleService{

    @Autowired
    @Qualifier("userRoleDAO")
    UserRoleDAO userRoleDAO;

    @Override
    public UserRole acceptUserRoleDetails(UserRole userRole) {
        return userRoleDAO.save(userRole);
    }

    @Override
    public UserRole findUserRoleDetails(int userRoleId) throws UserRoleNotFoundException {
        UserRole savedUserRole = userRoleDAO.findById(userRoleId).get();
        if(savedUserRole == null){
            throw  new UserRoleNotFoundException("User role not found for id : " + userRoleId);
        }
        return  savedUserRole;
    }
}
