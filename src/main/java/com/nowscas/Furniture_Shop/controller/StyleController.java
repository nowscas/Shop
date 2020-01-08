package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

@Controller
public class StyleController {
    @Autowired
    private StyleService styleService;

    /**
     * Метот дает команду на сохранение стиля категории в БД и возвращает страницу стилей категории.
     * @param categoryStyleName
     * @param categoryId
     * @param file
     * @return
     */
    @PostMapping("/addCategoryStyle")
    public String addCategoryStyle(
            @RequestParam String categoryStyleName,
            @RequestParam String categoryStyleDescription,
            @RequestParam Long categoryId,
            @RequestParam("file") MultipartFile file,
            Model model) throws IOException {
        if (file.isEmpty() || file.getSize() < 0 || !requireNonNull(file.getContentType()).contains("image")) {
            model.addAttribute("styles", styleService.getCategoryStyles(categoryId));
            model.addAttribute("categoryId", categoryId);
            model.addAttribute("message", "Выбран не подходящий файл!");
            return "categoryPage";
        } else {
            styleService.createCategoryStyle(categoryStyleName, categoryStyleDescription, categoryId, file);
        }
        return "redirect:/categoryPage/" + categoryId;
    }
}
