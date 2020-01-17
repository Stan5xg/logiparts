package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.UserRegistrationDto;
import com.carbontec.logiparts.jpa.entities.User;
import com.carbontec.logiparts.jpa.repositories.UserRepository;
import com.carbontec.logiparts.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User registerNewUserAccount(UserRegistrationDto userRegistrationDto) {
        User user = modelMapper.map(userRegistrationDto, User.class);

        userRepository.save(user);

        return user;
    }
}
