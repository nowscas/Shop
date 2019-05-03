package com.nowscas.Furniture_Shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MainPageCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cardHeader;
    private String cardText;
    private String cardImagePath;
    private String cardPrice;
    private String imageSide;

    public MainPageCard(String cardHeader, String cardText) {
        this.cardHeader = cardHeader;
        this.cardText = cardText;
    }

    public MainPageCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardHeader() {
        return cardHeader;
    }

    public void setCardHeader(String cardHeader) {
        this.cardHeader = cardHeader;
    }

    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }

    public String getCardImagePath() {
        return cardImagePath;
    }

    public void setCardImagePath(String cardImagePath) {
        this.cardImagePath = cardImagePath;
    }

    public String getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(String cardPrice) {
        this.cardPrice = cardPrice;
    }

    public String getImageSide() {
        return imageSide;
    }

    public void setImageSide(String imageSide) {
        this.imageSide = imageSide;
    }
}
