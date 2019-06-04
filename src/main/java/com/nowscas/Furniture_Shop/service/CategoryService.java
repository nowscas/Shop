package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.Category;
import com.nowscas.Furniture_Shop.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс для работы с категориями.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    /**
     * Метод вовращает все категории.
     * @return
     */
    public Iterable<Category>getAllCategories() {
        return categoryRepo.findAll();
    }

    /**
     * Метод сохраняет новую запись категории.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        Category category = new Category(categoryName);
        categoryRepo.save(category);
    }
}
