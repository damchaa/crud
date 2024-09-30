package com.shopping.crud.controller;

import com.shopping.crud.model.Categories;
import com.shopping.crud.model.Product;
import com.shopping.crud.repository.CategoriesRepository;
import com.shopping.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600,allowCredentials = "true")
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductByName(@PathVariable long id){
        return productRepository.findProductById(id);
    }
    @GetMapping("/categories")
    public List<Categories> getAllCategories(){
        List<Categories> categories = categoriesRepository.findAll();


        return categories;
    }
    @GetMapping("/categories/{id}")
    public List<Product> getProductByIdCategories(@PathVariable long id){
        return categoriesRepository.findById(id).getSetProduct();
    }

}
