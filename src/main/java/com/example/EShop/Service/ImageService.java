package com.example.EShop.Service;

import com.example.EShop.Model.Image;
import com.example.EShop.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    // Find image by id
    public Image findById(Integer id) throws Exception {
        return imageRepository.findById(id).orElseThrow(Exception::new);
    }

    // Delete image by id
    public String deleteById(Integer id) {
        imageRepository.deleteById(id);
        return "Image number " + id + " has been deleted!";
    }

    // Change image by id
    public Image changeById(Integer id, Image imageEntity) throws Exception {
        return imageRepository.findById(id)
                .map(image-> {
                    image.setUrl(imageEntity.getUrl());
                    image.setProductId(imageEntity.getProductId());
                    return imageRepository.save(image);
                }).orElseThrow( Exception::new);
    }

    // Create image
    public Image createImage(Image image)  {
        return imageRepository.save(image);
    }

    // Get all images
    public List<Image> getAll(){
        return imageRepository.findAll();
    }
}
