package com.example.EShop.Controller;

import com.example.EShop.Model.Tag;
import com.example.EShop.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;

    // Get tag by id
    @GetMapping("/{id}")
    public Tag getTag(@PathVariable ("id") Integer id) throws Exception {
        return tagService.findById(id);
    }

    // Change tag by id
    @PutMapping("/{id}")
    public Tag putTag(@PathVariable ("id") Integer id, @RequestBody Tag tag) throws Exception {
        return tagService.changeById(id, tag);
    }

    // Create tag
    @PostMapping
    public Tag postTag(@RequestBody Tag tag) throws Exception {
        tagService.createTag(tag);
        return tag;
    }

    // Delete tag
    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable ("id") Integer id)
    {
        tagService.deleteById(id);
    }

    // Get all tags
    @GetMapping(value="/all")
    public List<Tag> getAllTags() {
        return tagService.getAll();
    }
}