package com.upgrad.HireWheelsRev.service;

import com.upgrad.HireWheelsRev.dao.UserDAO;
import com.upgrad.HireWheelsRev.dao.UserRoleDAO;
import com.upgrad.HireWheelsRev.entity.User;
import com.upgrad.HireWheelsRev.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("initService")
public class InitServiceImpl implements InitService{

    @Autowired
    @Qualifier("userRoleDAO")
    UserRoleDAO userRoleDAO;

    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    @Override
    public void insertData() {
        insertUserRoles();
        insertUsers();
    }

    private void insertUserRoles(){
        UserRole admin = new UserRole();
        admin.setUserRoleName("Admin");

        UserRole customer = new UserRole();
        customer.setUserRoleName("Customer");

        userRoleDAO.save(admin);
        userRoleDAO.save(customer);
    }

    private void insertUsers(){
        User user = new User();
        user.setFirstName("Ram");
        user.setLastName("Kumaar");
        user.setEmail("ram@gmail.com");
        user.setMobile("1234567890");
        user.setPassword("password");
        user.setWalletMoney(10000);
        user.setUserRole(userRoleDAO.findByUserRoleName("Customer"));
        userDAO.save(user);
    }
}
