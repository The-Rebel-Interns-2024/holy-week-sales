package com.serbatic.holyweeksales.business.services.product;


import com.serbatic.holyweeksales.client.StorehouseFeingClient;
import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.data.repositories.ProductRepository;
import com.serbatic.holyweeksales.presentation.dto.ProductResource;
import com.serbatic.holyweeksales.presentation.dto.ProductResponse;
import com.serbatic.holyweeksales.presentation.dto.ProductStorageResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final StorehouseFeingClient storehouseFeingClient;

    public ProductServiceImpl(ProductRepository productRepository, StorehouseFeingClient storehouseFeingClient) {
        this.productRepository = productRepository;
        this.storehouseFeingClient = storehouseFeingClient;
    }

    @Override
    public ProductResponse save(ProductResource productR) {
        String code = "";
        do {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
            if (productR.getName().length() < 3) {
                code = productR.getName().substring(0, 2).toUpperCase() + "-" + UUID.randomUUID() + "-" + dtf.format(LocalDate.now());
            } else {
                code = productR.getName().substring(0, 3).toUpperCase() + "-" + UUID.randomUUID() + "-" + dtf.format(LocalDate.now());
            }
        } while (productRepository.existsByCode(code));
        Product product = new Product();
        product.setCode(code);
        product.setDescription(productR.getDescription());
        product.setName(productR.getName());
        product.setPrice(productR.getPrice());
        product.setTax(productR.getTax());
        Product productCreated = productRepository.save(product);
        ProductStorageResource productStoreHouse = new ProductStorageResource(productCreated.getCode(), productCreated.getName());
        ResponseEntity<ProductStorageResource> productStorageResource = storehouseFeingClient.createProduct(productStoreHouse);
        return ProductResponse.productResponseMapping(productCreated);
    }

}
