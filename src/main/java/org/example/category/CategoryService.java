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

    public void removeCategory(int id){
        categoryRepository.removeCategory(id);
    }

    public CategoryEntity findById(int id){
        return categoryRepository.findById(id);
    }

    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }

    public void upDate(int id, CategoryEntity category){
         categoryRepository.upDate(id, category);
    }
}
