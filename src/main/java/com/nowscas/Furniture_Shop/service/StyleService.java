package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.Category;
import com.nowscas.Furniture_Shop.domain.CategoryStyle;
import com.nowscas.Furniture_Shop.domain.StyleExample;
import com.nowscas.Furniture_Shop.repos.CategoryRepo;
import com.nowscas.Furniture_Shop.repos.CategoryStyleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class StyleService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private CategoryStyleRepo categoryStyleRepo;
    @Autowired
    private StringService stringService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ExampleService exampleService;

    @Value("${upload.categoryStylePath}")
    private String stylePath;

    /**
     * Метод сохраняет новую запись стиля категории.
     * @param styleName
     * @param categoryId
     * @param file
     */
    public void createCategoryStyle(String styleName, String styleDesciption,  Long categoryId, MultipartFile file) throws IOException {
        Category category = categoryRepo.findById(categoryId).get();
        CategoryStyle categoryStyle = new CategoryStyle(styleName, styleDesciption, category);

        String filename = stringService.replaceChar(file.getOriginalFilename(), " ", "_");
        File uploadDir = new File(stylePath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = uuidFile + "." + filename;

        File output = new File(stylePath +  "/" + resultFilename);
        ImageIO.write(imageService.resizeImage(file.getBytes(), 300, 400), "png", output);

        categoryStyle.setFileName(resultFilename);
        categoryStyleRepo.save(categoryStyle);
    }

    public void deleteCategoryStyle(CategoryStyle categoryStyle) {
        Iterable<StyleExample> styleExamples = exampleService.getStyleExamples(categoryStyle.getId());
        for (StyleExample styleExample : styleExamples) {
            exampleService.deleteStyleExample(styleExample);
        }
        File file = new File(stylePath + "/" + categoryStyle.getFileName());
        categoryStyleRepo.delete(categoryStyle);
        file.delete();
    }

    public Iterable<CategoryStyle> getCategoryStyles(long categoryId) {
        return categoryStyleRepo.findByCategoryId(categoryId);
    }
}
