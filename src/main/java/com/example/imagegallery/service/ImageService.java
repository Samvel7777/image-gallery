package com.example.imagegallery.service;

import com.example.imagegallery.model.Image;
import com.example.imagegallery.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public void save(Image image) {
        imageRepository.save(image);
    }

    public List<Image> findAllByCategory_Id(int id) {
        return imageRepository.findAllByCategory_Id(id);
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}
