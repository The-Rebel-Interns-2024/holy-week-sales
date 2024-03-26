package com.serbatic.holyweeksales.business.services.product;


import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.presentation.dto.ProductResource;
import com.serbatic.holyweeksales.presentation.dto.ProductResponse;

public interface ProductService {

    ProductResponse save(ProductResource product);
}
