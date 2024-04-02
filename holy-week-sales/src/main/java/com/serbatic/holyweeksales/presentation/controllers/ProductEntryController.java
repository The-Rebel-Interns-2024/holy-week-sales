package com.serbatic.holyweeksales.presentation.controllers;

import com.serbatic.holyweeksales.business.services.product.ProductService;
import com.serbatic.holyweeksales.business.services.productEntry.ProductEntryService;
import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.presentation.dto.ProductEntryResponse;
import com.serbatic.holyweeksales.presentation.dto.StorageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entries")
public class ProductEntryController {
    @Autowired
    ProductEntryService productEntryService;

    @PostMapping()
    public ResponseEntity<ProductEntryResponse> createEntryProduct(@RequestBody StorageResource productR) {
        if(productR.getQuantity() > 0){
            ProductEntryResponse save = productEntryService.save(productR);
            if(save !=null){
                return ResponseEntity.ok(save);
            } else {
                return  ResponseEntity.badRequest().build();
            }
        } else{
            throw new IllegalArgumentException("The quantity is not valid.");
        }

    }
}
