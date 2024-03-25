package com.serbatic.holyweeksales.data.repositories;

import com.serbatic.holyweeksales.data.entities.Product;


import org.springframework.data.mongodb.repository.MongoRepository;



public interface ProductRepository extends MongoRepository<Product, Long> {

}
