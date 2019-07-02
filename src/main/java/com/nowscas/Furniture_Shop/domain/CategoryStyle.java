package com.nowscas.Furniture_Shop.domain;

import javax.persistence.*;

@Entity
public class CategoryStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String styleImage;
    private String styleName;

    @Column(length = 2048)
    private String styleDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;

    public CategoryStyle(String styleName, String styleDescription, Category category) {
        this.styleName = styleName;
        this.styleDescription = styleDescription;
        this.category = category;
    }

    public CategoryStyle() {
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getStyleImage() {
        return styleImage;
    }

    public void setStyleImage(String styleImage) {
        this.styleImage = styleImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long categoryId) {
        this.id = categoryId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

}
