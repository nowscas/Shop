package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * Метот дает команду на сохранение категории в БД и возвращает страницу категорий.
     * @param categoryName
     * @return
     */
    @PostMapping("/categories")
    public String addCategory(@RequestParam String categoryName) {
        categoryService.createCategory(categoryName);
        return "redirect:/categories";
    }
}
