package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.domain.Category;
import com.nowscas.Furniture_Shop.service.CategoryService;
import com.nowscas.Furniture_Shop.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

import static java.util.Objects.requireNonNull;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StyleService styleService;

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
     * Метод возвращает страницу с конкретной категорией.
     * @param category
     * @param model
     * @return
      */
    @GetMapping("/categoryPage/{category}")
    public String getCategory(@PathVariable Category category, Model model) {
        model.addAttribute("styles", styleService.getCategoryStyles(category.getId()));
        model.addAttribute("categoryId", category.getId());
        return "categoryPage";
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
        if (file.isEmpty() || file.getSize() < 0 || !requireNonNull(file.getContentType()).contains("image")) {
            model.put("message", "Выбран не подходящий файл!");
            model.put("categories", categoryService.getAllCategories());
            return "main";
        } else {
            categoryService.createCategory(categoryName, file);
        }
        return "redirect:/";
    }

    /**
     * Метод дает команду на удаление категории со всеми вложенными объектами.
     * @param category
     * @return
     */
    @GetMapping("/deleteCategory/{category}")
    public String deleteCategory(@PathVariable Category category) {
        categoryService.deleteCategory(category);
        return "redirect:/";
    }
}
