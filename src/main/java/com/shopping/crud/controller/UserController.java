package com.shopping.crud.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.shopping.crud.model.MyUser;
import com.shopping.crud.model.Order;
import com.shopping.crud.model.Product;
import com.shopping.crud.payload.OrderRequest;
import com.shopping.crud.payload.ProductOrderRequest;
import com.shopping.crud.payload.ProductRequest;
import com.shopping.crud.repository.OrderRepository;
import com.shopping.crud.repository.UserRepository;
import com.shopping.crud.security.jwt.AuthTokenFilter;
import com.shopping.crud.security.jwt.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600,allowCredentials = "true")
@RequestMapping("/api/test/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private JwtUtils jwtUtils;

    @PreAuthorize(("hasRole('USER')"))
    @PostMapping("/getOrder")
    public void doOrder(@RequestHeader Map<String, String> headers, @RequestBody List<Product> products){
        String jwt = headers.get("cookie").substring(7,139);
        String username = jwtUtils.getUserNameFromJwtToken(jwt);
        System.out.println(products);


        MyUser myUser = userRepository.findMyUserByUsername(username);
        Order order = new Order();
        order.setProducts(products);
        order.setMyUser(myUser);;
        LocalDate currentDate = LocalDate.now();
        order.setDate(currentDate);
        orderRepository.save(order);
        System.out.println(currentDate);
    }


}
