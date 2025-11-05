package com.category.controllers;

import com.category.dto.SalonDTO;
import com.category.model.Category;
import com.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories/salon-owner")
public class SalonCategoryController {

    public final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> CreateCategory(@RequestBody Category category) {
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(2L);
        Category categories = categoryService.saveCategory(category, salonDTO);
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id) throws Exception {

        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);
        Long salonId = salonDTO.getId();
        categoryService.deleteCategoryById(id, salonId);
        return ResponseEntity.ok("Category deleted successfully");
    }
    
}
