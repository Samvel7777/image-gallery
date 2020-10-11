package com.example.imagegallery.controller;

import com.example.imagegallery.model.Category;
import com.example.imagegallery.repository.CategoryRepository;
import com.example.imagegallery.service.CategoryService;
import com.example.imagegallery.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    @Value("${file.upload.dir}")
    private String uploadDir;

    private final CategoryService categoryService;

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category, @RequestParam("image") MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File image = new File(uploadDir, name);
        file.transferTo(image);
        category.setPicUrl(name);
        categoryService.save(category);
        String msg = "Category was added";
        return "redirect:/admin?msg=" + msg;
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@RequestParam("name") String imageName) throws IOException {
        InputStream in = new FileInputStream(uploadDir + File.separator + imageName);
        return IOUtils.toByteArray(in);
    }
}
