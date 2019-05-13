package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.service.MainPageCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MainPageCardService mainPageCardService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        model.put("cards", mainPageCardService.getAllMainPageCards());
        return "main";
    }

    @PostMapping("/main")
    public String addCard(
            @RequestParam String header,
            @RequestParam String text,
            @RequestParam("file") MultipartFile file) throws IOException {

        mainPageCardService.addMainPageCard(header, text, file);
        return "redirect:/main";
    }
}