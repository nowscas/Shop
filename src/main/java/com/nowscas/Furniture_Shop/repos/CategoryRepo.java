package com.nowscas.Furniture_Shop.repos;

import com.nowscas.Furniture_Shop.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс для работы с категориями в БД.
 */
public interface CategoryRepo extends CrudRepository<Category, Long> {
}