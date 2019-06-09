package com.nowscas.Furniture_Shop.repos;

import com.nowscas.Furniture_Shop.domain.StyleExample;
import org.springframework.data.repository.CrudRepository;

public interface StyleExampleRepo extends CrudRepository<StyleExample, Long> {
    Iterable<StyleExample> findByCategoryStyleId(Long styleId);
}
