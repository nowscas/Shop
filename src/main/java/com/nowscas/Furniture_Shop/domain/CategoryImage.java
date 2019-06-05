package com.nowscas.Furniture_Shop.domain;

import javax.persistence.*;

@Entity
public class CategoryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinTable(name = "category", joinColumns = @JoinColumn(name = "id"))
    private Long categoryId;

    private String categoryImage;

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
