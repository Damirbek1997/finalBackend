package com.example.EShop.Service;

import com.example.EShop.Model.Tag;
import com.example.EShop.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    // Find tag by id
    public Tag findById(Integer id) throws Exception {
        return tagRepository.findById(id).orElseThrow(Exception::new);
    }

    // Delete tag by id
    public String deleteById(Integer id) {
        tagRepository.deleteById(id);
        return "Tag number " + id + " has been deleted!";
    }

    // Change tag by id
    public Tag changeById(Integer id, Tag tagEntity) throws Exception {
        return tagRepository.findById(id)
                .map(tag-> {
                    tag.setActive(tagEntity.getActive());
                    tag.setDescription(tagEntity.getDescription());
                    tag.setImage(tagEntity.getImage());
                    tag.setName(tagEntity.getName());
                    return tagRepository.save(tag);
                }).orElseThrow( Exception::new);
    }

    // Create tag
    public Tag createTag(Tag tag)  {
        return tagRepository.save(tag);
    }

    // Get all tags
    public List<Tag> getAll(){
        return tagRepository.findAll();
    }
}
