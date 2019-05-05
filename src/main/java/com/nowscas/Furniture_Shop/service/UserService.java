package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.Role;
import com.nowscas.Furniture_Shop.domain.User;
import com.nowscas.Furniture_Shop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public void addUser(User user) {
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
    }

    /**
     * Метод проверяет наличие позьзователя по имени.
     * @param user
     * @return
     */
    public boolean ifUserExist(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        return userFromDb == null;
    }
}
