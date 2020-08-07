package com.upgrad.HireWheelsRev.util;

import com.upgrad.HireWheelsRev.dto.UserDTO;
import com.upgrad.HireWheelsRev.entity.User;
import com.upgrad.HireWheelsRev.entity.UserRole;
import com.upgrad.HireWheelsRev.exception.UserRoleNotFoundException;
import com.upgrad.HireWheelsRev.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOEntityMapper {
    @Autowired
    UserRoleService userRoleService;

    public User convertUserDTOUser(UserDTO userDTO) throws UserRoleNotFoundException {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setWalletMoney(userDTO.getWalletMoney());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setUserRole(userRoleService.findUserRoleDetails(userDTO.getUserRoleId()));
        return user;
    }
}
