package com.nowscas.Furniture_Shop.domain;

import javax.persistence.*;

@Entity
public class CategoryStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinTable(name = "category", joinColumns = @JoinColumn(name = "id"))
    private Long categoryId;

    private String styleImage;
    private String styleName;
    private String styleDesc;

    public CategoryStyle(String styleName, String styleDesc, Long categoryId) {
        this.styleName = styleName;
        this.styleDesc = styleDesc;
        this.categoryId = categoryId;
    }

    public CategoryStyle() {
    }

    public String getStyleImage() {
        return styleImage;
    }

    public void setStyleImage(String styleImage) {
        this.styleImage = styleImage;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getStyleDesc() {
        return styleDesc;
    }

    public void setStyleDesc(String styleDesc) {
        this.styleDesc = styleDesc;
    }
}
