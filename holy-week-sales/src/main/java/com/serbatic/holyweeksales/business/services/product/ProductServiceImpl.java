package com.serbatic.holyweeksales.business.services.product;

import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.data.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository proRep;
    @Override
    public List<Product> retrieveAll() {
        if(!proRep.findAll().isEmpty()){
            return  proRep.findAll();
        } else{
            throw new NoSuchElementException("The list of sales products is empty");
        }
    }

    @Override
    public Product retrieveByCode(String code) {

        if(proRep.existsByCode(code)){
               return  proRep.findByCode(code);
        } else{
            throw new IllegalArgumentException("The product with code: "+code+" does not exist");
        }
    }

    @Override
    public Product save(Product product) {
        return proRep.save(product);
    }
}
