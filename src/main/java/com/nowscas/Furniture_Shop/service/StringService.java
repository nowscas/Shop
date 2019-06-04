package com.nowscas.Furniture_Shop.service;

import org.springframework.stereotype.Service;

/**
 * Класс для операций со строками.
 */
@Service
public class StringService {
    /**
     * Метод заменяет символы в строке.
     * @param name
     * @param oldValue
     * @param newValue
     * @return
     */
    public String replaceChar(String name, String oldValue, String newValue) {
        return name.replace(oldValue, newValue);
    }
}
