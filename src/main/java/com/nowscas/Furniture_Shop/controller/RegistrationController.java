package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.domain.Role;
import com.nowscas.Furniture_Shop.domain.User;
import com.nowscas.Furniture_Shop.repos.UserRepo;
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

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromBd = userRepo.findByUsername(user.getUsername());

        if (userFromBd != null) {
            model.put("message", "User exists!!!");
            return "registration";
        }
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
