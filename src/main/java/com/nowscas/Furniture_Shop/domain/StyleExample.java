package com.nowscas.Furniture_Shop.domain;

import javax.persistence.*;

@Entity
public class StyleExample {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String exampleImage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_style_id", referencedColumnName = "id")
    private CategoryStyle categoryStyle;

    public StyleExample(CategoryStyle categoryStyle) {
        this.categoryStyle = categoryStyle;
    }

    public StyleExample() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExampleImage() {
        return exampleImage;
    }

    public void setExampleImage(String exampleImage) {
        this.exampleImage = exampleImage;
    }

    public CategoryStyle getCategoryStyle() {
        return categoryStyle;
    }

    public void setCategoryStyle(CategoryStyle categoryStyle) {
        this.categoryStyle = categoryStyle;
    }
}
