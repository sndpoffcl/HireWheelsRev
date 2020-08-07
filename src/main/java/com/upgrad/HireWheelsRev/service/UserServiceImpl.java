package com.upgrad.HireWheelsRev.service;

import com.upgrad.HireWheelsRev.dao.UserDAO;
import com.upgrad.HireWheelsRev.dto.ForgetPWDDTO;
import com.upgrad.HireWheelsRev.entity.User;
import com.upgrad.HireWheelsRev.exception.DuplicateUserDetailsException;
import com.upgrad.HireWheelsRev.exception.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    @Override
    public User acceptUserDetails(User user) throws DuplicateUserDetailsException {
        User savedUserEmail = userDAO.findByEmail(user.getEmail());
        User savedUserMobile = userDAO.findByMobile(user.getMobile());
        if(savedUserEmail != null || savedUserMobile != null){
            throw new DuplicateUserDetailsException("User with email :" + user.getEmail() +
                    " User with mobile :" + user.getMobile() + "already exists" );
        }
        User savedUser = userDAO.save(user);
        return savedUser;
    }

    @Override
    public User updateUserDetails(int userId, User user) throws UserDetailsNotFoundException {
        User savedUser = findUserDetails(userId);
        User updatedUser = userDAO.save(user);
        return updatedUser;
    }

    @Override
    public User findUserDetails(int userId) throws UserDetailsNotFoundException {
        User savedUser = userDAO.findById(userId).get();
        if(savedUser == null) {
            throw new UserDetailsNotFoundException("user details not found for id : " + userId);
        }
        return savedUser;
    }

    @Override
    public User deleteUserDetails(int userId) {
        return null;
    }

    @Override
    public User updatePassword(ForgetPWDDTO forgetPWDDTO) throws Exception {
        User savedUser = userDAO.findByEmailAndMobile(forgetPWDDTO.getEmail() , forgetPWDDTO.getMobileNo());
        if(savedUser == null){
            throw  new Exception("User not found");
        }
        int savedUserId = savedUser.getId();
        savedUser.setPassword(forgetPWDDTO.getPassword());
        User updatedUser = updateUserDetails(savedUserId, savedUser);
        return updatedUser;
    }
}
