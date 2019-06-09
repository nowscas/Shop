package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.domain.CategoryStyle;
import com.nowscas.Furniture_Shop.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StyleExampleController {
    @Autowired
    ExampleService exampleService;

    /**
     * Метод возвращает страницу с конкретным стилем.
     * @param categoryStyle
     * @param model
     * @return
     */
    @GetMapping("/styleExample/{categoryStyle}")
    public String getExamplePage(@PathVariable CategoryStyle categoryStyle, Model model) {
        model.addAttribute("examples", exampleService.getStyleExamples(categoryStyle.getId()));
        model.addAttribute("styleId", categoryStyle.getId());
        return "styleExamples";
    }
}
