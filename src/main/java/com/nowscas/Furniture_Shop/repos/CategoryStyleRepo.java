package com.nowscas.Furniture_Shop.repos;

import com.nowscas.Furniture_Shop.domain.CategoryStyle;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс для работы с категориями в БД.
 */
public interface CategoryStyleRepo extends CrudRepository<CategoryStyle, Long> {
    Iterable<CategoryStyle> findByCategoryId(Long categoryId);
}
