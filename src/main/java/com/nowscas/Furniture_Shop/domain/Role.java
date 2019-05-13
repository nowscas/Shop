package com.nowscas.Furniture_Shop.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Список ролей для пользователей.
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
