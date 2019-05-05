package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.MainPageCard;
import com.nowscas.Furniture_Shop.repos.MainPageCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainPageCardService {
    @Autowired
    private MainPageCardRepo mainPageCardRepo;

    public Iterable<MainPageCard> getAllMainPageCards() {
        return mainPageCardRepo.findAll();
    }

    public void addMainPageCard(String header, String text) {
        MainPageCard mainPageCard = new MainPageCard(header, text);
        mainPageCardRepo.save(mainPageCard);
    }
}
