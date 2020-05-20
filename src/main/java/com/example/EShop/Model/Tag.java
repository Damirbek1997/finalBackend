package com.example.EShop.Model;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 500)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "categoryId", nullable = false, updatable = false)
    private Integer categoryId;

    @Column(name = "tagImage", length = 1000)
    private String image;

    public Tag(Integer id, String name, String description, Boolean isActive, Integer categoryId, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.categoryId = categoryId;
        this.image = image;
    }

    public Tag() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
