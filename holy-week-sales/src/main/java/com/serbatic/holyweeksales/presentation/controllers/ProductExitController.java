package com.serbatic.holyweeksales.presentation.controllers;

import com.serbatic.holyweeksales.clients.StorehouseFeingClient;
import com.serbatic.holyweeksales.presentation.dto.StorageResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exit_sales")
public class ProductExitController {

    private final StorehouseFeingClient storehouseFeingClient;

    public ProductExitController(StorehouseFeingClient storehouseFeingClient) {
        this.storehouseFeingClient = storehouseFeingClient;
    }


    @PostMapping()
    public ResponseEntity<StorageResource> createProductExit(@RequestBody StorageResource exitsStorageResource) {
        if (validateProductExit(exitsStorageResource)){
            return storehouseFeingClient.createProductExit(exitsStorageResource);
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
