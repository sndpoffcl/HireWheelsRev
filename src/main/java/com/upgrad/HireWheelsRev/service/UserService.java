package com.upgrad.HireWheelsRev.service;

import com.upgrad.HireWheelsRev.dto.ForgetPWDDTO;
import com.upgrad.HireWheelsRev.entity.User;
import com.upgrad.HireWheelsRev.exception.DuplicateUserDetailsException;
import com.upgrad.HireWheelsRev.exception.UserDetailsNotFoundException;

public interface UserService {
    User acceptUserDetails(User user) throws DuplicateUserDetailsException;
    User updateUserDetails(int userId, User user) throws UserDetailsNotFoundException;
    User findUserDetails(int userId) throws UserDetailsNotFoundException;
    User deleteUserDetails(int userId);
    User updatePassword(ForgetPWDDTO forgetPWDDTO) throws Exception;
}
