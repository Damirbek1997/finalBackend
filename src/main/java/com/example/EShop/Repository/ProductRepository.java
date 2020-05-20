package com.example.EShop.Repository;

import com.example.EShop.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByPriceBetween(BigDecimal low, BigDecimal high);
    List<Product> findByNameContaining(String text);
    List<Product> findByCategoryEquals(Integer category);
    List<Product> findBySubCategoryEquals(Integer subcategory);
    List<Product> findByTagEquals(Integer tag);
}
