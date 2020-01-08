package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

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
            Map<String, Object> model) throws IOException {
        if (file.isEmpty() || file.getSize() < 0 || !requireNonNull(file.getContentType()).contains("image")) {
            model.put("message", "Выбран не подходящий файл!");
            return "redirect:/categoryPage/" + categoryId;
        } else {
            styleService.createCategoryStyle(categoryStyleName, categoryStyleDescription, categoryId, file);
        }
        return "redirect:/categoryPage/" + categoryId;
    }
}
