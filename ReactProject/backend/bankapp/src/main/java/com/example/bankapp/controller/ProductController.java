package com.example.bankapp.controller;

import com.example.bankapp.model.Product;
import com.example.bankapp.model.User;
import com.example.bankapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping(value = "/saveProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> print(@RequestBody Product prod) {
        productService.store(prod);
        return new ResponseEntity<Product>(prod, HttpStatus.CREATED);
    }

    @GetMapping(value = "/Products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProd() {
        List<Product> list = productService.getProducts();
        return new ResponseEntity<List<Product>>(list, HttpStatus.CREATED);
    }
    @GetMapping(value = "/Product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProd(@PathVariable("id") int id) {
        Product prod = productService.getProduct(id);
        return new ResponseEntity<Product>(prod, HttpStatus.CREATED);
    }

}
