package com.nowscas.Furniture_Shop.domain;


import javax.persistence.*;

@Entity
public class StyleExampleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private StyleExample styleExample;

    private String fileName;

    public StyleExampleImage(StyleExample styleExample) {
        this.styleExample = styleExample;
    }

    public StyleExampleImage() {
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

    public StyleExample getStyleExample() {
        return styleExample;
    }

    public void setStyleExample(StyleExample styleExample) {
        this.styleExample = styleExample;
    }
}
