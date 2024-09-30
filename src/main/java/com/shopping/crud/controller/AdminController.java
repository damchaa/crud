package com.shopping.crud.controller;

import com.shopping.crud.model.ERole;
import com.shopping.crud.model.MyUser;
import com.shopping.crud.model.Product;
import com.shopping.crud.model.Role;
import com.shopping.crud.repository.ProductRepository;
import com.shopping.crud.repository.RoleRepository;
import com.shopping.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600,allowCredentials = "true")
@RequestMapping("/api/test/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/getAllUser")
    public List<MyUser> getAllUser(){
        return userRepository.findAll();
    }
    @PostMapping("/addNewUser")
    public void addNewUser(@RequestBody MyUser myUser){
        MyUser user = new MyUser(myUser.getUsername(), myUser.getEmail(), myUser.getPassword());
        Role role = new Role(ERole.ROLE_USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
    }
    @PostMapping("/deleteUserById")
    public void deleteUserById(@RequestBody MyUser user){
        userRepository.deleteById(user.getId());
    }


}
