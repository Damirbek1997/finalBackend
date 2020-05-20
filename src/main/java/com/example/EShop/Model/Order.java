package com.example.EShop.Model;

import com.example.EShop.GlobalVariables.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "delivery_address",length = 1000)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name =  "status")
    private Status status;

    @Column(name = "user_email",nullable = false, updatable = false)
    private String userEmail;

    @Column(name = "order_items")
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Product> orderItems;

    public Order(Integer id, BigDecimal total, Date orderDate, String address, Status status, String userEmail, List<Product> orderItems) {
        this.id = id;
        this.total = total;
        this.orderDate = orderDate;
        this.address = address;
        this.status = status;
        this.userEmail = userEmail;
        this.orderItems = orderItems;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Product> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Product> orderItems) {
        this.orderItems = orderItems;
    }
}
