package com.example.imagegallery.controller;

import com.example.imagegallery.model.Category;
import com.example.imagegallery.model.Image;
import com.example.imagegallery.service.CategoryService;
import com.example.imagegallery.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ImageController {

    @Value("${file.upload.dir}")
    private String uploadDir;

    private final ImageService imageService;
    private final CategoryService categoryService;

    @PostMapping("/addImage")
    public String addImage(@ModelAttribute Image image, @RequestParam("image") MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File images = new File(uploadDir, name);
        file.transferTo(images);
        image.setPicUrl(name);
        imageService.save(image);
        String msg = "Image was added";
        return "redirect:/admin?msg=" + msg;
    }

    @GetMapping("/imageView{categoryName}")
    public String image(ModelMap modelMap, @PathVariable String categoryName) {
        Category category = categoryService.findByName(categoryName);
        List<Image> imageList = null;
        if (category != null) {
            imageList = imageService.findAllByCategory_Id(category.getId());
        }
        modelMap.addAttribute("categories", category);
        modelMap.addAttribute("imagesList", imageList);
        return "image";
    }
}
