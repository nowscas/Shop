package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.CategoryStyle;
import com.nowscas.Furniture_Shop.domain.StyleExample;
import com.nowscas.Furniture_Shop.repos.CategoryStyleRepo;
import com.nowscas.Furniture_Shop.repos.StyleExampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ExampleService {
    @Autowired
    StyleExampleRepo styleExampleRepo;
    @Autowired
    CategoryStyleRepo categoryStyleRepo;
    @Autowired
    private ImageService imageService;
    @Autowired
    private StringService stringService;

    @Value("${upload.categoryExamplePath}")
    private String uploadPath;

    /**
     * Метод возвращает примеры по id стиля.
     */
    public Iterable<StyleExample>getStyleExamples(long styleId) {
        return styleExampleRepo.findByCategoryStyleId(styleId);
    }

    /**
     * Метод сохраняет пример стиля в бд.
     * @param exampleDesc
     * @param styleId
     * @param file
     */
    public void addExample(String exampleDesc, Long styleId, MultipartFile file) throws IOException {
        CategoryStyle categoryStyle = categoryStyleRepo.findById(styleId).get();
        StyleExample styleExample = new StyleExample(exampleDesc, categoryStyle);

        String filename = stringService.replaceChar(file.getOriginalFilename(), " ", "_");
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = uuidFile + "." + filename;

        File output = new File(uploadPath +  "/" + resultFilename);
        ImageIO.write(imageService.resizeImage(file.getBytes(), 300, 400), "png", output);

        styleExample.setExampleImage(resultFilename);
        styleExampleRepo.save(styleExample);
    }
}
