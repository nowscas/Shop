package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.StyleExample;
import com.nowscas.Furniture_Shop.repos.StyleExampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    @Autowired
    StyleExampleRepo styleExampleRepo;

    public Iterable<StyleExample>getStyleExamples(long styleId) {
        return styleExampleRepo.findByCategoryStyleId(styleId);
    }
}
