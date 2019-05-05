package com.nowscas.Furniture_Shop.repos;

import com.nowscas.Furniture_Shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
