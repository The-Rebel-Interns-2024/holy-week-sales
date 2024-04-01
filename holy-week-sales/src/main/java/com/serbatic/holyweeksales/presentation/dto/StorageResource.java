package com.serbatic.holyweeksales.presentation.dto;

public class StorageResource {
    String code;
    Integer quantity;

    public StorageResource() {
    }

    public StorageResource(String code, Integer quantity) {
        this.code = code;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
