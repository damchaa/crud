package com.shopping.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "product_task")
public class ProductTask {
    @Id
    private long id;
    private String product_name;
    private Date product_date;
    private int product_price;

}
