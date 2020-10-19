package com.example.imagegallery.controller;

import com.example.imagegallery.model.Category;
import com.example.imagegallery.model.Image;
import com.example.imagegallery.service.CategoryService;
import com.example.imagegallery.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ImageService imageService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public String home(ModelMap modelMap) {
        List<Image> images = imageService.findAll();
        List<Category> categories = categoryService.findAll();
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("images", images);
        return "index";
    }


}
