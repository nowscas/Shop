package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.CategoryStyle;
import com.nowscas.Furniture_Shop.domain.StyleExample;
import com.nowscas.Furniture_Shop.domain.StyleExampleImage;
import com.nowscas.Furniture_Shop.repos.CategoryStyleRepo;
import com.nowscas.Furniture_Shop.repos.StyleExampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ExampleService {
    @Autowired
    private StyleExampleRepo styleExampleRepo;
    @Autowired
    private CategoryStyleRepo categoryStyleRepo;
    @Autowired
    private StyleExampleImageService styleExampleImageService;
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
     */
    public void addExample(Long styleId, MultipartFile file) throws IOException {
        CategoryStyle categoryStyle = categoryStyleRepo.findById(styleId).get();
        StyleExample styleExample = new StyleExample(categoryStyle);

        String filename = stringService.replaceChar(file.getOriginalFilename(), " ", "_");
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = uuidFile + "." + filename;

        File output = new File(uploadPath +  "/" + resultFilename);
        ImageIO.write(imageService.resizeImage(file.getBytes(), 300, 400), "png", output);

        styleExample.setFileName(resultFilename);
        styleExampleRepo.save(styleExample);
    }

    public void deleteStyleExample(StyleExample styleExample) {
        List<StyleExampleImage> exampleImages = styleExample.getExampleImages();
        for (StyleExampleImage styleExampleImage: exampleImages) {
            styleExampleImageService.deleteExampleImage(styleExampleImage);
        }
        File file = new File(uploadPath + "/" + styleExample.getFileName());
        styleExampleRepo.delete(styleExample);
        file.delete();
    }
}
