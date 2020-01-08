package com.nowscas.Furniture_Shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class StyleExample {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_style_id", referencedColumnName = "id")
    private CategoryStyle categoryStyle;

    @OneToMany(mappedBy = "styleExample", cascade = CascadeType.ALL)
    private List<StyleExampleImage> exampleImages;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public CategoryStyle getCategoryStyle() {
        return categoryStyle;
    }

    public void setCategoryStyle(CategoryStyle categoryStyle) {
        this.categoryStyle = categoryStyle;
    }

    public List<StyleExampleImage> getExampleImages() {
        return exampleImages;
    }

    public void setExampleImages(List<StyleExampleImage> exampleImages) {
        this.exampleImages = exampleImages;
    }
}
