package com.example.EShop.Controller;

import com.example.EShop.Model.SubCategory;
import com.example.EShop.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    // Get subcategory by id
    @GetMapping("/{id}")
    public SubCategory getSubCategory(@PathVariable ("id") Integer id) throws Exception {
        return subCategoryService.findById(id);
    }

    // Change subcategory by id
    @PutMapping("/{id}")
    public SubCategory putSubCategory(@PathVariable ("id") Integer id, @RequestBody SubCategory subcategory) throws Exception {
        return subCategoryService.changeById(id, subcategory);
    }

    // Create subcategory
    @PostMapping
    public SubCategory postSubCategory(@RequestBody SubCategory subcategory) throws Exception {
        subCategoryService.createSubCategory(subcategory);
        return subcategory;
    }

    // Delete subcategory by id
    @DeleteMapping("/{id}")
    public void deleteSubCategory(@PathVariable ("id") Integer id) {
        subCategoryService.deleteById(id);
    }

    // Get all subcategories
    @GetMapping(value="/all")
    public List<SubCategory> getAllCategories() {
        return subCategoryService.getAll();
    }
}