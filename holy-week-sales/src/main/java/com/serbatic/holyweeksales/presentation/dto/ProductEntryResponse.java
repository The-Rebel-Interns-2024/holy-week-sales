package com.serbatic.holyweeksales.presentation.dto;

import com.serbatic.holyweeksales.data.entities.Product;

public class ProductEntryResponse {
    private String name;
    private String code;
    private String description;
    private float price;
    private float tax;
    private Long quantity;

    public ProductEntryResponse() {
    }

    public ProductEntryResponse(String name, String code, String description, float price, float tax, Long quantity) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.tax = tax;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public static ProductEntryResponse from(Product product, Long quantity){
        return new ProductEntryResponse(
                product.getName(),
                product.getCode(),
                product.getDescription(),
                product.getPrice(),
                product.getTax(),
                quantity);
    }

}
