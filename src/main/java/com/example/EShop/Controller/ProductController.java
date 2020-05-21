package com.example.EShop.Controller;

import com.example.EShop.Model.Product;
import com.example.EShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get product by id
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable ("id") Integer id) throws Exception {
        return productService.findById(id);
    }

    // Change product by id
    @PutMapping("/{id}")
    public Product putProduct(@PathVariable ("id") Integer id ,@RequestBody Product product) throws Exception {
        productService.changeById(id, product);
        return product;
    }

    // Create product
    @RequestMapping(method = RequestMethod.POST)
    public Product postProduct(@RequestBody Product product) throws Exception {
        productService.createProduct(product);
        return product;
    }

    // Delete by id
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable ("id") Integer id) {
        productService.deleteById(id);
    }

    // Get all products
    @GetMapping(value="/all")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    // Get all products by rating
    @GetMapping(value="/allbyrating")
    public List<Product> getAllProductsByRating() {
        return productService.getAllByRating();
    }

    // Search product by price
    @GetMapping(value="/price/{low}/{high}")
    public List<Product> byPrice(@PathVariable (name = "low",required = false) BigDecimal low,
                                       @PathVariable ("high") BigDecimal high){
        if (low == null){ low = BigDecimal.valueOf(0); }

        return productService.getByPrice(low,high);
    }

    // Search by name
    @GetMapping(value="/search/{text}")
    public List<Product> byName(@PathVariable ("text") String text) {
        if(text.equals("")){
            return null;
        }
        else {
            return productService.getByName(text);
        }
    }

    // Search by category and id
    @GetMapping("/category/{id}")
    public List<Product> getByCategory(@PathVariable ("id") Integer id) throws Exception {
        return productService.getByCategory(id);
    }

    // Search by subcategory and id
    @GetMapping("/subcategory/{id}")
    public List<Product> getBySubCategory(@PathVariable ("id") Integer id) throws Exception {
        return productService.getBySubcategory(id);
    }

    // Get by tag and id
    @GetMapping("/tag/{id}")
    public List<Product> getByTag(@PathVariable ("id") Integer id) throws Exception {
        return productService.getByTag(id);
    }

}
