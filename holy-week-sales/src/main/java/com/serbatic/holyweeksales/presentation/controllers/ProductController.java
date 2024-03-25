package com.serbatic.holyweeksales.presentation.controllers;

import com.serbatic.holyweeksales.business.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

//    @PostMapping()
//    public ResponseEntity<Product> createProduct(@RequestBody String name) {
//        return ResponseEntity.ok().build();
//    }

}
