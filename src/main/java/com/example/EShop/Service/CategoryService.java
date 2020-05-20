package com.example.EShop.Service;

import com.example.EShop.Model.Category;
import com.example.EShop.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    // Find by id
    public Category findById(Integer id) throws Exception {
        return categoryRepository.findById(id).orElseThrow(Exception::new);
    }

    // Delete by id
    public String deleteById(Integer id) {
        categoryRepository.deleteById(id);
        return "Category number " + id + " has been deleted!";
    }

    // Update category by id
    public Category changeById(Integer id, Category category) throws Exception {
        return categoryRepository.findById(id)
                .map(category1 -> {
                    category.setName(category.getName());
                    category.setTags(category.getTags());
                    category.setImage(category.getImage());
                    category.setActive(category.getActive());
                    category.setSubCategories(category.getSubCategories());
                    return categoryRepository.save(category);
                }).orElseThrow(Exception::new);
    }

    // Create category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get all
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
