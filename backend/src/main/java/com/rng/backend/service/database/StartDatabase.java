package com.rng.backend.service.database;

import com.rng.backend.entities.Product;
import com.rng.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StartDatabase {

    @Autowired
    private ProductRepository productRepository;

    public void StartDB(){

        Product car = new Product(null, "Car blue", 12000.00);
        Product cellPhone = new Product(null, "iphone", 2150.00);

        productRepository.saveAll(Arrays.asList(car, cellPhone));
    }
}