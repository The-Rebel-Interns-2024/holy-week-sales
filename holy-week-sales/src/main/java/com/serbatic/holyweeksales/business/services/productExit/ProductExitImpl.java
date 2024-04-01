package com.serbatic.holyweeksales.business.services.productExit;

import com.serbatic.holyweeksales.clients.StorehouseFeingClient;
import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.data.repositories.ProductRepository;
import com.serbatic.holyweeksales.presentation.dto.ProductExitResponse;
import com.serbatic.holyweeksales.presentation.dto.StorageResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
            try {
                StorageResource response = storehouseFeingClient.createProductExit(storageResource).getBody();

                if(response != null){

                    prodExitResp.setName(product.get().getName());
                    prodExitResp.setCode(product.get().getCode());
                    prodExitResp.setDescription(product.get().getDescription());
                    prodExitResp.setPrice(product.get().getPrice());
                    prodExitResp.setQuantity(storageResource.getQuantity());

                    return  prodExitResp;

                } else {

                    throw new IllegalArgumentException("The productExit don't create");

                }

            } catch (Exception ex){

                return null;
            }


        } else {

            throw new NoSuchElementException("The product don´t exist");
        }
    }
}
