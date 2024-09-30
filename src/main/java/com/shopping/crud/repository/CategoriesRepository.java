package com.shopping.crud.repository;

import com.shopping.crud.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {
    Categories findById(long id);
    Categories findByCategoriesName(String name);
}
