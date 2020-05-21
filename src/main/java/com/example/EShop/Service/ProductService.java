package com.example.EShop.Service;

import com.example.EShop.Model.Product;
import com.example.EShop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Find by id
    public Product findById(Integer id) throws Exception {
        return productRepository.findById(id).orElseThrow(Exception::new);
    }

    // Delete by id
    public String deleteById(Integer id) {
        productRepository.deleteById(id);
        return "Product number " + id + " has been deleted!";
    }

    // Change by id
    public Product changeById(Integer id, Product productEntity) throws Exception {
        return productRepository.findById(id)
                .map(product-> {
                    product.setInStock(productEntity.isInStock());
                    product.setRating(productEntity.getRating());
                    product.setCategory(productEntity.getCategory());
                    product.setColor(productEntity.getColor());
                    product.setDescription(productEntity.getDescription());
                    product.setImages(productEntity.getImages());
                    product.setSubCategory(productEntity.getSubCategory());
                    product.setName(productEntity.getName());
                    product.setSize(productEntity.getSize());
                    product.setPrice(productEntity.getPrice());
                    return productRepository.save(product);
                }).orElseThrow( Exception::new);
    }

    // Create product
    public Product createProduct(Product productEntity)  {
        return productRepository.save(productEntity);
    }

    // Get all products
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    // Get all by rating
    public List<Product> getAllByRating(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,"rating"));
    }

    // Get by price
    public List<Product> getByPrice(BigDecimal low, BigDecimal high){
        return productRepository.findByPriceBetween(low,high);
    }

    // Get by name
    public List<Product> getByName(String text){
        return productRepository.findByNameContaining(text);
    }

    // Get by category
    public List<Product> getByCategory(Integer category){
        return productRepository.findByCategoryEquals(category);
    }

    // Get by subcategory
    public List<Product> getBySubcategory(Integer subcategory){
        return productRepository.findBySubCategoryEquals(subcategory);
    }

    // Get by tag
    public List<Product> getByTag(Integer tag){
        return productRepository.findByTagEquals(tag);
    }
}