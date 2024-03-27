package com.serbatic.holyweeksales.business.services.product;


import com.serbatic.holyweeksales.data.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> retrieveAll();
    Product retrieveByCode(String code);
    Product save(Product product);
}
