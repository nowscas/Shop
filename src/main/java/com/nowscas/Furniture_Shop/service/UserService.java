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
import java.util.Map;

/**
 * Класс для работы с пользователями.
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    /**
     * Метод возвращает пользователя из БД по имени.
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public void addUser(User user) {
        user.setRoles(Collections.singleton(Role.USER));
        user.setBlocked(false);
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

    /**
     * Метод возвращает список всех пользователей.
     * @return
     */
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    /**
     * Метод сохраняет измененного пользователя.
     * @param username
     * @param form
     * @param user
     */
    public void saveChanged(String username, Map<String, String> form, User user) {
        user.setUsername(username);
        for (Map.Entry<String, String> entry : form.entrySet()) {
            if (entry.getKey().equals("blocked") && entry.getValue().equals("on")) {
                user.setBlocked(true);
                break;
            } else {
                user.setBlocked(false);
            }
        }
        userRepo.save(user);
    }
}
