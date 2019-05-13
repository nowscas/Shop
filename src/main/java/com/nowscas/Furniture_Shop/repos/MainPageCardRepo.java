package com.nowscas.Furniture_Shop.repos;

import com.nowscas.Furniture_Shop.domain.MainPageCard;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс для работы с записями карточек главной страницы в БД.
 */
public interface MainPageCardRepo extends CrudRepository<MainPageCard, Long> {
}
