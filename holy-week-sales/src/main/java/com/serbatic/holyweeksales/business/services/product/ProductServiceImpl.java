package com.serbatic.holyweeksales.business.services.product;


import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.data.repositories.ProductRepository;
import com.serbatic.holyweeksales.presentation.dto.ProductResource;
import com.serbatic.holyweeksales.presentation.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductResponse save(ProductResource productR) {
        validateProduct(productR);
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
       return  ProductResponse.productResponseMapping(productCreated);
    }

    private void validateProduct(ProductResource productR) {
        if (productR.getPrice() <= 0) {
            throw new IllegalArgumentException("The entered price is negative.");
        }
        if (productR.getTax() <= 0 || productR.getTax() > 21) {
            throw new IllegalArgumentException("The entered tax is not valid. Must be greater than 0 and maximum 21");
        }
        if (productR.getName().length() < 2) {
            throw new IllegalArgumentException("The entered name length must be minimum 2.");
        }
    }
}
