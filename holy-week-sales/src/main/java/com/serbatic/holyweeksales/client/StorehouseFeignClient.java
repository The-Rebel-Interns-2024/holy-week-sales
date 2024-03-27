package com.serbatic.holyweeksales.client;

import com.serbatic.holyweeksales.presentation.dto.ProductStorageResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "storehouse-feing-client" , url = "${storehouse.service.url}")
public interface StorehouseFeignClient {
    @PostMapping("/product")
    ResponseEntity<ProductStorageResource> createProduct(@RequestBody ProductStorageResource productStorageResource);
}
