package com.example.EShop.Controller;

import com.neobis.eshop.entity.TagEntity;
import com.neobis.eshop.service.TagService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти тэг по id")
    public TagEntity getTag(@PathVariable ("id") Integer id) throws Exception {
        return tagService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить тэг")
    public TagEntity putTag(@PathVariable ("id") Integer id ,@RequestBody TagEntity tagEntity) throws Exception {
        return tagService.changeById(id,tagEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать тэг")
    public TagEntity postTag(@RequestBody TagEntity tagEntity) throws Exception {
        tagService.createTag(tagEntity);
        return tagEntity;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить тэг")
    public void deleteTag(@PathVariable ("id") Integer id)
    {
        tagService.deleteById(id);
    }

    @GetMapping(value="/all")
    @ApiOperation(value = "Получить все тэги")
    public List<TagEntity> getAllTags() {
        return tagService.getAll();
    }
}