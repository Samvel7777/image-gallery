package com.example.imagegallery.service;

import com.example.imagegallery.model.Category;
import com.example.imagegallery.model.Image;
import com.example.imagegallery.repository.CategoryRepository;
import com.example.imagegallery.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category findByName(String name)  {
        return categoryRepository.findByName(name);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
