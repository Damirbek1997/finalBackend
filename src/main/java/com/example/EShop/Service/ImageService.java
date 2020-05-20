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

    public Image findById(Integer id) throws Exception {
        return imageRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        imageRepository.deleteById(id);
        return "Image number " + id + " has been deleted!";
    }

    public Image changeById(Integer id, Image imageEntity) throws Exception {
        return imageRepository.findById(id)
                .map(image-> {
                    image.setUrl(imageEntity.getUrl());
                    image.setProductId(imageEntity.getProductId());
                    return imageRepository.save(image);
                }).orElseThrow( Exception::new);
    }

    public Image createImage(Image image)  {
        return imageRepository.save(image);
    }

    public List<Image> getAll(){
        return imageRepository.findAll();
    }
}
