package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.StyleExampleImage;
import com.nowscas.Furniture_Shop.repos.StyleExampleImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class StyleExampleImageService {

    @Autowired
    private StyleExampleImageRepo styleExampleImageRepo;
    @Autowired
    private ImageService imageService;
    @Autowired
    private StringService stringService;

    @Value("${upload.categoryExampleImagePath}")
    private String uploadPath;

    public StyleExampleImage addImageToGallery(MultipartFile file) throws IOException {
        StyleExampleImage styleExampleImage = new StyleExampleImage();

        String filename = stringService.replaceChar(file.getOriginalFilename(), " ", "_");
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = uuidFile + "." + filename;

        File output = new File(uploadPath +  "/" + resultFilename);
        ImageIO.write(imageService.resizeImage(file.getBytes(), 600, 800), "png", output);

        styleExampleImage.setImagePath(resultFilename);
        styleExampleImageRepo.save(styleExampleImage);
        return styleExampleImage;
    }
}
