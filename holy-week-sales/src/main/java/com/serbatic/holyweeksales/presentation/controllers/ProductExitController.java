package com.serbatic.holyweeksales.presentation.controllers;

import com.serbatic.holyweeksales.business.services.productExit.ProductExitService;
import com.serbatic.holyweeksales.clients.StorehouseFeingClient;
import com.serbatic.holyweeksales.presentation.dto.ProductExitResponse;
import com.serbatic.holyweeksales.presentation.dto.StorageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exits")
public class ProductExitController {

    @Autowired
    ProductExitService productExitService;

    @PostMapping()
    public ResponseEntity<ProductExitResponse> createProductExit(@RequestBody StorageResource storageResource) {

        if (validateProductExit(storageResource)){
            ResponseEntity<ProductExitResponse> productExitResponse = productExitService.createProductExit(storageResource) ;

            if(productExitResponse != null){

                return productExitResponse;

            } else {

                return ResponseEntity.badRequest().build();
            }
        } else {
            throw new IllegalArgumentException("The quantity is negative.");
        }
    }

    private boolean validateProductExit(StorageResource exitsStorageResource) {
        if (exitsStorageResource.getQuantity() <= 0) {
            return  false;
        }
        return  true;
    }

}
