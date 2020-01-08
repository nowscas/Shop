package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.Category;
import com.nowscas.Furniture_Shop.domain.CategoryStyle;
import com.nowscas.Furniture_Shop.domain.StyleExample;
import com.nowscas.Furniture_Shop.repos.CategoryRepo;
import com.nowscas.Furniture_Shop.repos.CategoryStyleRepo;
import com.nowscas.Furniture_Shop.repos.StyleExampleImageRepo;
import com.nowscas.Furniture_Shop.repos.StyleExampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Класс для работы с категориями.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private CategoryStyleRepo categoryStyleRepo;

    @Autowired
    private ImageService imageService;
    @Autowired
    private StringService stringService;
    @Autowired
    private ExampleService exampleService;

    @Value("${upload.categoryImagePath}")
    private String categoryPath;
    @Value("${upload.categoryStylePath}")
    private String stylePath;

    /**
     * Метод вовращает все категории.
     * @return
     */
    public Iterable<Category>getAllCategories() {
        return categoryRepo.findAll();
    }

    /**
     * Метод сохраняет новую запись категории.
     * @param categoryName
     */
    public void createCategory(String categoryName, MultipartFile file) throws IOException {
        Category category = new Category(categoryName);

        String filename = stringService.replaceChar(file.getOriginalFilename(), " ", "_");
        File uploadDir = new File(categoryPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = uuidFile + "." + filename;

            File output = new File(categoryPath +  "/" + resultFilename);
            ImageIO.write(imageService.resizeImage(file.getBytes(), 300, 400), "png", output);

        category.setFileName(resultFilename);
        categoryRepo.save(category);
    }

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

        categoryStyle.setStyleImage(resultFilename);
        categoryStyleRepo.save(categoryStyle);
    }

    public Iterable<CategoryStyle>getCategoryStyles(long categoryId) {
        return categoryStyleRepo.findByCategoryId(categoryId);
    }

    public void deleteCategory(Category category) {
        Iterable<CategoryStyle> categoryStyles = getCategoryStyles(category.getId());
        for (CategoryStyle categoryStyle: categoryStyles) {
            deleteCategoryStyle(categoryStyle);
        }
        File file = new File(categoryPath + "/" + category.getFileName());
        categoryRepo.delete(category);
        file.delete();
    }

    public void deleteCategoryStyle(CategoryStyle categoryStyle) {
        Iterable<StyleExample> styleExamples = exampleService.getStyleExamples(categoryStyle.getId());
        for (StyleExample styleExample : styleExamples) {
            exampleService.deleteStyleExample(styleExample);
        }
        File file = new File(stylePath + "/" + categoryStyle.getStyleImage());
        categoryStyleRepo.delete(categoryStyle);
        file.delete();
    }
}
