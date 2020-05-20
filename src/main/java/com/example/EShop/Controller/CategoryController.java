package com.example.EShop.Controller;

import com.example.EShop.Model.Category;
import com.example.EShop.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    // Get category by id
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Integer id) throws Exception {
        return categoryService.findById(id);
    }

    // Change category by id
    @PutMapping("/{id}")
    public Category putCategory(@PathVariable ("id") Integer id ,@RequestBody Category category) throws Exception {
        return categoryService.changeById(id,category);
    }

    // Create category
    @RequestMapping(method = RequestMethod.POST)
    public Category postCategory(@RequestBody Category category) throws Exception {
        categoryService.createCategory(category);
        return category;
    }

    // Delete category by id
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable ("id") Integer id) {
        categoryService.deleteById(id);
    }

    // Get all categories
    @GetMapping(value="/all")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }
}
