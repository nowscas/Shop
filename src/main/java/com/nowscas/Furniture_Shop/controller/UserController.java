package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.domain.User;
import com.nowscas.Furniture_Shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Класс обрабатывает запросы касающиеся пользователя.
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Метод возвращает страницу со всеми пользователями.
     * @param model
     * @return
     */
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }

    /**
     * Метод возвращает страницу редактирования указанного пользователя.
     * @param user
     * @param model
     * @return
     */
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "userEdit";
    }

    /**
     * Метод сохраняет изменения данных пользователя.
     * @param username
     * @param form
     * @param user
     * @return
     */
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        userService.saveChanged(username, form, user);
        return "redirect:/user";
    }
}
