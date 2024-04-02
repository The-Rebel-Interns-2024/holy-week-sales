package com.serbatic.holyweeksales.business.services.product;


import com.serbatic.holyweeksales.data.entities.Product;

import java.util.List;
import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.presentation.dto.ProductResource;
import com.serbatic.holyweeksales.presentation.dto.ProductResponse;

public interface ProductService {
    List<Product> retrieveAll();
    Product retrieveByCode(String code);
    ProductResponse save(ProductResource product);
}
