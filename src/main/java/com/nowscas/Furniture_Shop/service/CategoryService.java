package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.Category;
import com.nowscas.Furniture_Shop.domain.CategoryStyle;
import com.nowscas.Furniture_Shop.repos.CategoryRepo;
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
    private ImageService imageService;
    @Autowired
    private StringService stringService;
    @Autowired
    private StyleService styleService;

    @Value("${upload.categoryImagePath}")
    private String categoryPath;

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

    public void deleteCategory(Category category) {
        Iterable<CategoryStyle> categoryStyles = styleService.getCategoryStyles(category.getId());
        for (CategoryStyle categoryStyle: categoryStyles) {
            styleService.deleteCategoryStyle(categoryStyle);
        }
        File file = new File(categoryPath + "/" + category.getFileName());
        categoryRepo.delete(category);
        file.delete();
    }
}
