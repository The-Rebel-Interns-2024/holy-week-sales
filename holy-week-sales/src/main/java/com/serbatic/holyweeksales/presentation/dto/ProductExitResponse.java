package com.serbatic.holyweeksales.presentation.dto;

import com.serbatic.holyweeksales.data.entities.Product;

public class ProductExitResponse {
    private String name;
    private String code;
    private String description;
    private Float price;
    private Integer quantity;

    public ProductExitResponse() {
    }

    public ProductExitResponse(String name, String code, String description, Float price, Integer quantity) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

      public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
