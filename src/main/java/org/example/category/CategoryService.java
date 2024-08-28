package org.example.category;

import java.util.List;
import java.util.UUID;

public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(CategoryEntity category){
        categoryRepository.addCategory(category);
    }

    public void removeCategory(UUID id){
        categoryRepository.removeCategory(id);
    }

    public CategoryEntity findById(UUID id){
        return categoryRepository.findById(id);
    }

    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }

    public void upDate(UUID id, CategoryEntity category){
         categoryRepository.upDate(id, category);
    }
}
