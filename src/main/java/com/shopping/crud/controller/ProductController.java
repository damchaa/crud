package com.shopping.crud.controller;



import com.shopping.crud.model.Categories;
import com.shopping.crud.model.Product;
import com.shopping.crud.payload.ProductRequest;
import com.shopping.crud.repository.CategoriesRepository;
import com.shopping.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600,allowCredentials = "true")

@RequestMapping("/api/test/admin")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        List productList = new ArrayList();
        productList.addAll(productRepository.findAll());
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
        return productList;
    }
    @PostMapping("/addProduct")
    public void createProduct(@RequestBody ProductRequest productRequest){

        Product product =  new Product(productRequest.getName(), productRequest.getArticle(), productRequest.getDescription(),Integer.parseInt(productRequest.getPrice()),productRequest.getColor(),productRequest.getSize(),Integer.parseInt(productRequest.getCount()),categoriesRepository.findByCategoriesName(productRequest.getCategories()));
        productRepository.save(product);



    }
    @PreAuthorize(("hasRole('ADMIN')"))
    @PostMapping("/deleteById/{id}")
    public void deleteByUd(@PathVariable long id){
        productRepository.deleteById(id);


    }


}
