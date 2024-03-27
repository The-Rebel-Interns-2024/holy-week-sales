package com.serbatic.holyweeksales.business.services.product;


import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.data.repositories.ProductRepository;
import com.serbatic.holyweeksales.presentation.dto.ProductResource;
import com.serbatic.holyweeksales.presentation.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> retrieveAll() {
        if(!productRepository.findAll().isEmpty()){
            return  productRepository.findAll();
        } else{
            throw new NoSuchElementException("The list of sales products is empty");
        }
    }

    @Override
    public Product retrieveByCode(String code) {

        if(productRepository.existsByCode(code)){
            return  productRepository.findByCode(code);
        } else{
            throw new IllegalArgumentException("The product with code: "+code+" does not exist");
        }
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
       return  ProductResponse.productResponseMapping(productCreated);
    }

}
