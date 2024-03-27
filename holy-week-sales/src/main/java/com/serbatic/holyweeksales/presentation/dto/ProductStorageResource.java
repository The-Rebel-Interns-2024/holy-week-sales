package com.serbatic.holyweeksales.presentation.dto;

import com.serbatic.holyweeksales.data.entities.Product;

public class ProductStorageResource {
    String code;
    String name;

    public ProductStorageResource(String code, String name) {
        this.code = code;
        this.name = name;
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
}
