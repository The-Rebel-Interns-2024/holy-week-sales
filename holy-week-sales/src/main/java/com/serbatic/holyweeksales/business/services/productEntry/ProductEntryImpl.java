package com.serbatic.holyweeksales.business.services.productEntry;

import com.serbatic.holyweeksales.business.services.product.ProductService;
import com.serbatic.holyweeksales.business.services.product.ProductServiceImpl;
import com.serbatic.holyweeksales.clients.StorehouseFeingClient;
import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.presentation.dto.ProductEntryResponse;
import com.serbatic.holyweeksales.presentation.dto.StorageResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductEntryImpl implements ProductEntryService {
    private final ProductService productService;
    private final StorehouseFeingClient storehouseFeingClient;

    public ProductEntryImpl(ProductService productService, StorehouseFeingClient storehouseFeingClient) {
        this.productService = productService;
        this.storehouseFeingClient = storehouseFeingClient;
    }


    @Override
    public ProductEntryResponse save(StorageResource storageResource) {
        Product product = productService.retrieveByCode(storageResource.getCode());
        try{
            ResponseEntity<ProductEntryResponse> entryProduct = storehouseFeingClient.createEntryProduct(storageResource);
            return ProductEntryResponse.from(product, Long.valueOf(storageResource.getQuantity()));
        } catch (Exception ex){
            return null;
        }
    }
}
