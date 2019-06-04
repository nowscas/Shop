package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.Category;
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

    @Value("${upload.categoryImagePath}")
    private String uploadPath;

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
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = uuidFile + "." + filename;

            File output = new File(uploadPath +  "/" + resultFilename);
            ImageIO.write(imageService.resizeImage(file.getBytes(), 200, 300), "png", output);

        category.setFileName(resultFilename);
        categoryRepo.save(category);
    }
}
