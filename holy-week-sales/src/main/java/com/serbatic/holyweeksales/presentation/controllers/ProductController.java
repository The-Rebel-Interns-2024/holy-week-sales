package com.serbatic.holyweeksales.presentation.controllers;

import com.serbatic.holyweeksales.business.services.product.ProductService;
import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.presentation.dto.ProductResource;
import com.serbatic.holyweeksales.presentation.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductResource productR) {
        validateProduct(productR);
        return ResponseEntity.ok(productService.save(productR));
    }


    private void validateProduct(ProductResource productR) {
        if (productR.getPrice() <= 0) {
            throw new IllegalArgumentException("The entered price is negative.");
        }
        if (productR.getTax() <= 0 || productR.getTax() > 21) {
            throw new IllegalArgumentException("The entered tax is not valid. Must be greater than 0 and maximum 21");
        }
        if (productR.getName().length() < 2) {
            throw new IllegalArgumentException("The entered name length must be minimum 2.");
        }
    }

}
