package com.carbontec.logiparts.services;

import com.carbontec.logiparts.dto.UserRegistrationDto;
import com.carbontec.logiparts.jpa.entities.User;

public interface UserService {
    User registerNewUserAccount(UserRegistrationDto userRegistrationDto);
}
