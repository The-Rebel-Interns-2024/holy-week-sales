package com.serbatic.holyweeksales.business.services.productExit;

import com.serbatic.holyweeksales.clients.StorehouseFeingClient;
import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.data.repositories.ProductRepository;
import com.serbatic.holyweeksales.presentation.dto.ProductExitResponse;
import com.serbatic.holyweeksales.presentation.dto.StorageResource;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductExitImpl implements ProductExitService {

    private final ProductRepository productRepository;
    private final StorehouseFeingClient storehouseFeingClient;

    public ProductExitImpl(ProductRepository productRepository, StorehouseFeingClient storehouseFeingClient) {
        this.productRepository = productRepository;
        this.storehouseFeingClient = storehouseFeingClient;
    }


    @Override
    public ProductExitResponse createProductExit (StorageResource storageResource){

        ProductExitResponse prodExitResp = new ProductExitResponse();
        Optional<Product> product = productRepository.findByCode(storageResource.getCode());

        if(!product.isEmpty()){

            if(storehouseFeingClient.createProductExit(storageResource).equals(storageResource)){

                prodExitResp.setName(product.get().getName());
                prodExitResp.setCode(product.get().getCode());
                prodExitResp.setDescription(product.get().getDescription());
                prodExitResp.setPrice(product.get().getPrice());
                prodExitResp.setQuantity(storageResource.getQuantity());
                return  prodExitResp;
            }

        } else {

            throw new NoSuchElementException("The product don´t exist");
        }

        return  prodExitResp;
    }
}
