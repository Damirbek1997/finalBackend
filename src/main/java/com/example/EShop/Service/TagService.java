package com.example.EShop.Service;

import com.neobis.eshop.entity.TagEntity;
import com.neobis.eshop.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public TagEntity findById(Integer id) throws Exception {
        return tagRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        tagRepository.deleteById(id);
        return "Tag number " + id + " has been deleted!";
    }

    public TagEntity changeById(Integer id,TagEntity tagEntity) throws Exception {
        return tagRepository.findById(id)
                .map(tag-> {
                    tag.setActive(tagEntity.isActive());
                    tag.setDescription(tagEntity.getDescription());
                    tag.setId(tagEntity.getId());
                    tag.setImage(tagEntity.getImage());
                    tag.setName(tagEntity.getName());
                    return tagRepository.save(tag);
                }).orElseThrow( Exception::new);
    }

    public TagEntity createTag(TagEntity tagEntity)  {
        return tagRepository.save(tagEntity);
    }

    public List<TagEntity> getAll(){
        return tagRepository.findAll();
    }

}
