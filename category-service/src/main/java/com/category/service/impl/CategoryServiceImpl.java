package com.category.service.impl;

import com.category.dto.SalonDTO;
import com.category.model.Category;
import com.category.repository.CategoryRepository;
import com.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(Category category, SalonDTO salonDTO) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setImage(category.getImage());
        newCategory.setSalonId(salonDTO.getId());
        return categoryRepository.save(newCategory);

    }

    @Override
    public Set<Category> getAllCategoriesBySalonId(Long salonId) {
        return categoryRepository.findBySalonId(salonId).stream().collect(Collectors.toSet());
    }

    @Override
    public Category getCategoryById(Long categoryId) throws Exception {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category==null){
            throw new Exception("Category not found with id: " + categoryId);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Long categoryId, Long salonId) throws Exception {

        Category category = getCategoryById(categoryId);
        if(!category.getSalonId().equals(salonId)){
            throw new Exception("You are not authorized to delete this category");
        }
        categoryRepository.deleteById(categoryId);
    }
}
