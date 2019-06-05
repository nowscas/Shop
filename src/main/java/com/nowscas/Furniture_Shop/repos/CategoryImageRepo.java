package com.nowscas.Furniture_Shop.repos;

import com.nowscas.Furniture_Shop.domain.CategoryImage;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс для работы с категориями в БД.
 */
public interface CategoryImageRepo extends CrudRepository<CategoryImage, Long> {
    Iterable<CategoryImage> findByCategoryId(Long categoryId);
}
