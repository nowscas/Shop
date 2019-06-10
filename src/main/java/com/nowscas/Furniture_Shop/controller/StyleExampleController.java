package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.domain.CategoryStyle;
import com.nowscas.Furniture_Shop.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

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

    /**
     * Метод дает команду на создание примера стиля.
     */
    @PostMapping("/addExample")
    public String addExample(
            @RequestParam String exampleDesc,
            @RequestParam Long styleId,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) throws IOException {
        if (file.isEmpty() || file.getSize() < 0 || !Objects.requireNonNull(file.getContentType()).contains("image")) {
            model.put("message", "Выбран не подходящий файл!");
            return "redirect:/categoryPage/" + styleId;
        } else {
            exampleService.addExample(exampleDesc, styleId, file);
        }
        return "redirect:/styleExample/" + styleId;
    }
}
