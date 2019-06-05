package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("categories", categoryService.getAllCategories());
        return "main";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }
}