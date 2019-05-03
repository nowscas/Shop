package com.nowscas.Furniture_Shop;

import com.nowscas.Furniture_Shop.domain.MainPageCard;
import com.nowscas.Furniture_Shop.repos.MainPageCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MainPageCardRepo mainPageCardRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<MainPageCard> cards = mainPageCardRepo.findAll();
        model.put("cards", cards);
        return "main";
    }

    @PostMapping
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