package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.service.MainPageCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MainPageCardService mainPageCardService;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("cards", mainPageCardService.getAllMainPageCards());
        return "main";
    }
}