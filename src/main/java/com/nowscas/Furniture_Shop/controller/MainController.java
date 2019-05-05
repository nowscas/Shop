package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.domain.MainPageCard;
import com.nowscas.Furniture_Shop.repos.MainPageCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MainPageCardRepo mainPageCardRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<MainPageCard> cards = mainPageCardRepo.findAll();
        model.put("cards", cards);
        return "main";
    }

    @PostMapping("/main")
    public String addCard(
            @RequestParam String header,
            @RequestParam String text,
            Map<String, Object> model) {
        MainPageCard mainPageCard = new MainPageCard(header, text);
        mainPageCardRepo.save(mainPageCard);

        Iterable<MainPageCard> cards = mainPageCardRepo.findAll();
        model.put("cards", cards);
        return "main";
    }
}