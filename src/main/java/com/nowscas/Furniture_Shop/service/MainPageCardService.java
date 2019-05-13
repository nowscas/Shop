package com.nowscas.Furniture_Shop.service;

import com.nowscas.Furniture_Shop.domain.MainPageCard;
import com.nowscas.Furniture_Shop.repos.MainPageCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Класс для работы с карточками главной страницы.
 */
@Service
public class MainPageCardService {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private MainPageCardRepo mainPageCardRepo;

    /**
     * Метод возвращает все записи карточек главной страницы.
     * @return
     */
    public Iterable<MainPageCard> getAllMainPageCards() {
        return mainPageCardRepo.findAll();
    }

    /**
     * Метод сохраняет новую запись карточки главной страницы.
     * @param header
     * @param text
     * @param file
     * @throws IOException
     */
    public void addMainPageCard(String header, String text, MultipartFile file) throws IOException {
        MainPageCard mainPageCard = new MainPageCard(header, text);
        if (file.getSize() != 0 && !file.getOriginalFilename().isEmpty()) {
            if (file.getContentType().contains("image")) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();

                file.transferTo(new File(uploadPath + "/" + resultFilename));
                mainPageCard.setCardImagePath(resultFilename);
            }
        }
        mainPageCardRepo.save(mainPageCard);
    }
}
