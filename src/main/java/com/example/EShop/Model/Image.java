package com.example.EShop.Model;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "image_id")
    private Integer id;

    @Column(name = "url",length = 1000)
    private String url;

    @Column(name = "product_id")
    private Integer productId;

    public Image(Integer id, String url, Integer productId) {
        this.id = id;
        this.url = url;
        this.productId = productId;
    }

    public Image() {
    }

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
