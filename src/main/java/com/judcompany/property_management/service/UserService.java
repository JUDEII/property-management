package com.judcompany.property_management.service;

import com.judcompany.property_management.dto.UserDTO;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);
}
