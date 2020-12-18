package com.rng.backend.service;

import com.rng.backend.entities.Product;
import com.rng.backend.repositories.ProductRepository;
import com.rng.backend.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){

        return productRepository.findAll();
    }

    public Product findById(Long id){

        return productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
    }

    public void save(Product product){

        productRepository.save(product);
    }

    public void update(Long id, Product newProduct){
        Product oldProduct = this.findById(id);
        newProduct.setId(oldProduct.getId());

        productRepository.save(newProduct);
    }

    public void deleteById(Long id){

        productRepository.deleteById(id);
    }
}