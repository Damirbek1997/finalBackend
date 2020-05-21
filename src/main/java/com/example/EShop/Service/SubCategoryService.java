package com.example.EShop.Service;

import com.example.EShop.Model.SubCategory;
import com.example.EShop.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subcategoryRepository;

    // Find subcategory by id
    public SubCategory findById(Integer id) throws Exception {
        return subcategoryRepository.findById(id).orElseThrow(Exception::new);
    }

    // Delete subcategory by id
    public String deleteById(Integer id) {
        subcategoryRepository.deleteById(id);
        return "SubCategory number " + id + " has been deleted!";
    }

    // Change subcategory by id
    public SubCategory changeById(Integer id,SubCategory subcategoryEntity) throws Exception {
        return subcategoryRepository.findById(id)
                .map(subcategory-> {
                    subcategory.setName(subcategoryEntity.getName());
                    subcategory.setActive(subcategoryEntity.getActive());
                    subcategory.setDescription(subcategoryEntity.getDescription());
                    subcategory.setCategoryId(subcategoryEntity.getCategoryId());
                    subcategory.setImage(subcategoryEntity.getImage());
                    return subcategoryRepository.save(subcategory);
                }).orElseThrow( Exception::new);
    }

    // Create subcategory
    public SubCategory createSubCategory(SubCategory subcategoryEntity)  {
        return subcategoryRepository.save(subcategoryEntity);
    }

    // Get all subcategories
    public List<SubCategory> getAll(){
        return subcategoryRepository.findAll();
    }
}
