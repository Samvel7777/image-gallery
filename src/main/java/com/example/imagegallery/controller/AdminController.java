package com.example.imagegallery.controller;

import com.example.imagegallery.model.Category;
import com.example.imagegallery.model.Image;
import com.example.imagegallery.repository.CategoryRepository;
import com.example.imagegallery.repository.ImageRepository;
import com.example.imagegallery.service.CategoryService;
import com.example.imagegallery.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ImageService imageService;
    private final CategoryService categoryService;

    @GetMapping("/admin")
    public String adminPage(ModelMap modelMap, @RequestParam(value = "msg", required = false) String msg) {
        List<Image> image = imageService.findAll();
        List<Category> category = categoryService.findAll();
        modelMap.addAttribute("images", image);
        modelMap.addAttribute("categories", category);
        modelMap.addAttribute("msg", msg);
        return "admin";
    }
}
