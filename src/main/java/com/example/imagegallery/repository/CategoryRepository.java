package com.example.imagegallery.repository;

import com.example.imagegallery.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category findByName(String name);
}
