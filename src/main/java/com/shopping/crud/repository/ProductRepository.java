package com.shopping.crud.repository;

import com.shopping.crud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductByName(String name);
    Product findProductById(Long Id);
    void deleteProductById(Long id);
}
