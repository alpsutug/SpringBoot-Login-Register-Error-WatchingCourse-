package com.simpleform.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "order_table")
public class OrderModel {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
    Integer id;

    private Integer usersTableId;

    private Integer productTableId;

    private Integer orderAmount;

    private Timestamp orderDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersTableId() {
        return usersTableId;
    }

    public void setUsersTableId(Integer usersTableId) {
        this.usersTableId = usersTableId;
    }

    public Integer getProductTableId() {
        return productTableId;
    }

    public void setProductTableId(Integer productTableId) {
        this.productTableId = productTableId;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderDate(java.security.Timestamp orderDate) {
    }
}
