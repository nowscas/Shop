package com.nowscas.Furniture_Shop.controller;

import com.nowscas.Furniture_Shop.domain.CategoryStyle;
import com.nowscas.Furniture_Shop.domain.StyleExample;
import com.nowscas.Furniture_Shop.repos.CategoryStyleRepo;
import com.nowscas.Furniture_Shop.service.ExampleService;
import com.nowscas.Furniture_Shop.service.StyleExampleImageService;
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
    private ExampleService exampleService;
    @Autowired
    private StyleExampleImageService styleExampleImageService;

    @Autowired
    private CategoryStyleRepo categoryStyleRepo;

    /**
     * Метод возвращает страницу с конкретным стилем.
     * @param categoryStyle
     * @param model
     * @return
     */
    @GetMapping("/styleExample/{categoryStyle}")
    public String getExamplePage(@PathVariable CategoryStyle categoryStyle, Model model) {
        model.addAttribute("styleDesc", categoryStyle.getStyleDescription());
        model.addAttribute("styleName", categoryStyle.getStyleName());
        model.addAttribute("examples", exampleService.getStyleExamples(categoryStyle.getId()));
        model.addAttribute("styleId", categoryStyle.getId());
        return "styleExamples";
    }

    /**
     * Метод дает команду на создание примера стиля.
     */
    @PostMapping("/addExample")
    public String addExample(
            @RequestParam Long styleId,
            @RequestParam("file") MultipartFile file,
            Model model) throws IOException {
        if (file.isEmpty() || file.getSize() < 0 || !Objects.requireNonNull(file.getContentType()).contains("image")) {
            CategoryStyle categoryStyle = categoryStyleRepo.findById(styleId).get();
            model.addAttribute("styleDesc", categoryStyle.getStyleDescription());
            model.addAttribute("styleName", categoryStyle.getStyleName());
            model.addAttribute("examples", exampleService.getStyleExamples(categoryStyle.getId()));
            model.addAttribute("styleId", categoryStyle.getId());
            model.addAttribute("message", "Выбран не подходящий файл!");
            return "styleExamples";
        } else {
            exampleService.addExample(styleId, file);
        }
        return "redirect:/styleExample/" + styleId;
    }

    /**
     * Метод дает команду на сохранение картинки примера.
     */
    @PostMapping("/addExampleImage")
    public String editExample(
            @RequestParam MultipartFile file,
            @RequestParam("exampleId") StyleExample styleExample,
            @RequestParam("styleId") CategoryStyle categoryStyle,
            Map<String, Object> model
    ) throws IOException {
        if (file.isEmpty() || file.getSize() < 0 || !Objects.requireNonNull(file.getContentType()).contains("image")) {
            model.put("message", "Выбран не подходящий файл!");
            return "redirect:/categoryPage/" + categoryStyle.getId();
        } else {
            styleExampleImageService.addImageToGallery(file, styleExample);
        }
        return "redirect:/styleExample/" + categoryStyle.getId();
    }
}
