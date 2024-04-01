package com.serbatic.holyweeksales.data.repositories;

import com.serbatic.holyweeksales.data.entities.Product;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories
public interface ProductRepository extends MongoRepository<Product, Long> {

    Product findByCode(String code);
    Boolean existsByCode(String code);
}
