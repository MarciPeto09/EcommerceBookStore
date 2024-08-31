package org.example.category;

import java.util.List;

public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(CategoryEntity category){
        categoryRepository.add(category);
    }

    public void removeCategory(int id){
        categoryRepository.remove(id);
    }

    public CategoryEntity findById(int id){
        return categoryRepository.findById(id);
    }

    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }

    public void upDate(int id, CategoryEntity category){
         categoryRepository.update(id, category);
    }
}
