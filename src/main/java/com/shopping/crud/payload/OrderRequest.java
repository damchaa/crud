package com.shopping.crud.payload;

import com.shopping.crud.model.Product;

import java.util.List;

public class OrderRequest {
    private List<ProductRequest> basket;
    private String username;


    public OrderRequest(){

    }
    public OrderRequest( List<ProductRequest> basket) {

        this.basket = basket;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ProductRequest> getProducts() {
        return basket;
    }

    public void setProducts(List<ProductRequest> products) {
        this.basket = products;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "login='" + '\'' +
                ", products=" + basket +
                '}';
    }
}
