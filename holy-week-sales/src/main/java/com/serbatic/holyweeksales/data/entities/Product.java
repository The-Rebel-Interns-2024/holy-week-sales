package com.serbatic.holyweeksales.data.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document(collection =  "product")
public class Product {
    @Id
    private String id;
    @Field("code")
    private String code;
    private String name;
    private String description;
    private float price;
    private float tax;

    public Product() {
    }

    public Product(String id, String code, String name, String description, float price, float tax) {
        this.id =   UUID.randomUUID().toString();;
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.tax = tax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                '}';
    }
}
