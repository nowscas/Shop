package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.service.MainPageCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainPageCardController {
    @Autowired
    private MainPageCardService mainPageCardService;

    /**
     * Метод возвращает страницу добавления карточки главной страницы.
     * @return
     */
    @GetMapping("/addMainPageCard")
    public String getAddCardPage() {
        return "addMainPageCard";
    }

    /**
     * Метод дает команду на сохранение карточки главной страницы в бд и возвращает главную страницу.
     * @param header
     * @param text
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/addMainPageCard")
    public String addMainPageCard(
            @RequestParam String header,
            @RequestParam String text,
            @RequestParam("file") MultipartFile file) throws IOException {
        mainPageCardService.addMainPageCard(header, text, file);
        return "redirect:/";
    }
}
