package com.carbontec.logiparts.services.impl;

import com.carbontec.logiparts.dto.UserRegistrationDto;
import com.carbontec.logiparts.jpa.entities.Department;
import com.carbontec.logiparts.jpa.entities.User;
import com.carbontec.logiparts.jpa.repositories.DepartmentRepository;
import com.carbontec.logiparts.jpa.repositories.UserRepository;
import com.carbontec.logiparts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public User registerNewUserAccount(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setEmail(userRegistrationDto.getEmail()); //add validation
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setMiddleName(userRegistrationDto.getMiddleName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setTitle(userRegistrationDto.getTitle());
        user.setNumber(userRegistrationDto.getNumber());

        int departmentId = userRegistrationDto.getDepartmentId();
        Department department = departmentRepository.findById(departmentId).get();//TODO add check for optional
//        user.setDepartment(department);

        userRepository.save(user);

        return user;
    }
}
