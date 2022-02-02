package com.example.bankapp.repo;

import com.example.bankapp.model.Product;
import com.example.bankapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
