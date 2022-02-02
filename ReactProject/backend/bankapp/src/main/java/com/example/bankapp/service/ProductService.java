package com.example.bankapp.service;

import com.example.bankapp.model.Product;

import com.example.bankapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public void store(Product prod) {productRepo.save(prod);
    }

    public List<Product> getProducts() {

        List<Product> list = productRepo.findAll();

        return list;
    }
    public Product getProduct(int id) {

        Product prod = productRepo.findById(id).orElse(new Product());

        return prod;
    }
}
