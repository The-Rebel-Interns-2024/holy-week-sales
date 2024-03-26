package com.serbatic.holyweeksales.presentation.dto;

public class ProductResponse {
    private String name;
    private String code;
    private String description;
    private Float price;
    private Float tax;
    private Float netPricePerUnit;

    public ProductResponse(String name, String code, String description, Float price, Float tax, Float netPrice) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.tax = tax;
        this.netPricePerUnit = netPrice;
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

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public Float getNetPrice() {
        return netPricePerUnit;
    }

    public void setNetPrice(Float netPrice) {
        this.netPricePerUnit = netPrice;
    }
}
