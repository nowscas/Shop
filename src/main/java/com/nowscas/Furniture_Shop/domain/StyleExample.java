package com.nowscas.Furniture_Shop.domain;

import javax.persistence.*;

@Entity
public class StyleExample {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String exampleImage;
    private String exampleDesc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_style_id", referencedColumnName = "id")
    private CategoryStyle categoryStyle;

    public StyleExample(String exampleDesc, CategoryStyle categoryStyle) {
        this.exampleDesc = exampleDesc;
        this.categoryStyle = categoryStyle;
    }

    public StyleExample() {
    }

    public Long getId() {
        return id;
    }

    public String getExampleDesc() {
        return exampleDesc;
    }

    public void setExampleDesc(String exampleDesc) {
        this.exampleDesc = exampleDesc;
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
