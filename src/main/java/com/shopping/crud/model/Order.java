package com.shopping.crud.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "MyUser_id")
    private MyUser user;

    @Column(name = "oderDate")
    private LocalDate date;

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "product_ID", referencedColumnName = "ID")
    )
    private List<Product> products;





    public void setId(long id) {
        this.id = id;
    }

    public MyUser getMyUser() {
        return user;
    }

    public void setMyUser(MyUser myUser) {
        this.user = myUser;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
