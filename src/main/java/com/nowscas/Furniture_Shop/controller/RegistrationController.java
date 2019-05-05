package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.domain.Role;
import com.nowscas.Furniture_Shop.domain.User;
import com.nowscas.Furniture_Shop.repos.UserRepo;
import com.nowscas.Furniture_Shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {

        if (!userService.ifUserExist(user)) {
            model.put("message", "User exists!!!");
            return "registration";
        }

        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
