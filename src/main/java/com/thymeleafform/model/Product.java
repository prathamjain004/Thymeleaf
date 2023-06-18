package com.thymeleafform.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @Column(name = "product_name")
    private String productName;

   @Column(name = "price")
    private Double price;

   @Column(nullable = true, length = 64)
   private String photos;

   @Transient
    public String getPhotosImagePath() {
        if (photos == null) return null;
        return "/product-photos/" + id + "/" + photos;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
