package com.carbontec.logiparts.controllers;

import com.carbontec.logiparts.dto.UserRegistrationDto;
import com.carbontec.logiparts.jpa.entities.User;
import com.carbontec.logiparts.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class RegistationController {
    @Resource
    private UserService userService;

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserRegistrationDto userDto = new UserRegistrationDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    //TODO try replace with path= and postmapping
    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") UserRegistrationDto userRegistrationDto,
             WebRequest request) {

        createUserAccount(userRegistrationDto, null);

        return null;
    }

    private User createUserAccount(UserRegistrationDto accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return registered;
    }
}
