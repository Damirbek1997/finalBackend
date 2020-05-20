package com.example.EShop.Controller;

import com.example.EShop.Model.Image;
import com.example.EShop.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    // Find by id
    @GetMapping("/{id}")
    public Image getImage(@PathVariable("id") Integer id) throws Exception {
        return imageService.findById(id);
    }

    // Create image
    @PostMapping
    public Image postImage(@RequestBody Image imageEntity) throws Exception {
        imageService.createImage(imageEntity);
        return imageEntity;
    }

    // Change image by id
    @PutMapping("/{id}")
    public Image putImage(@PathVariable ("id") Integer id, @RequestBody Image image) throws Exception {
        return imageService.changeById(id, image);
    }

    // Delete by id
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable ("id") Integer id) {
        imageService.deleteById(id);
    }

    @GetMapping(value="/all")
    public List<Image> getAllCategories() {
        return imageService.getAll();
    }
}
