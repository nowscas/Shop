package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * Метод возвращает страницу с категориями.
     * @return
     */
    @GetMapping("/categories")
    public String getCategoriesPage(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/addCategory")
    public String getAddPage() {
        return "addCategory";
    }

    /**
     * Метот дает команду на сохранение категории в БД и возвращает страницу категорий.
     * @param categoryName
     * @return
     */
    @PostMapping("/addCategory")
    public String addCategory(
            @RequestParam String categoryName,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) throws IOException {
        if (file.isEmpty() || file.getSize() < 0 || !Objects.requireNonNull(file.getContentType()).contains("image")) {
            model.put("message", "Выбран не подходящий файл!");
            return "addCategory";
        } else {
            categoryService.createCategory(categoryName, file);
        }
        return "redirect:/categories";
    }
}
