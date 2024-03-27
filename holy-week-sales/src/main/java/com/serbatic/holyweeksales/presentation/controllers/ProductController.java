package com.serbatic.holyweeksales.presentation.controllers;

import com.serbatic.holyweeksales.business.services.product.ProductService;
import com.serbatic.holyweeksales.data.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.retrieveAll();
    }
    /*@PostMapping
    public Product createProduct(@RequestBody Product product){
        return  productService.save(product);
    }*/

    @GetMapping("/{code}")
    public Product getAllProductsByCode(@PathVariable String code){
        return productService.retrieveByCode(code);
    }

}
