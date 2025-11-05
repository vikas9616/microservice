package com.category.service;

import com.category.dto.SalonDTO;
import com.category.model.Category;

import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, SalonDTO salonDTO);
    Set<Category> getAllCategoriesBySalonId(Long salonId);
    Category getCategoryById(Long categoryId) throws Exception;
    void deleteCategoryById(Long categoryId, Long salonId) throws Exception;
}
