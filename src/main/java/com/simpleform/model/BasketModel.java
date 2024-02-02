package com.simpleform.model;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "basket_table")
public class BasketModel {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basket_seq")
    @SequenceGenerator(name =  "basket_seq", sequenceName =  "basket_seq", allocationSize = 1)
    Integer id;

    @Column(name = "users_table_id")
    private Integer usersTableId;

    @Column(name = "product_table_id")
    private Integer productTableId;

    @Column(name = "basket_amount")
    private Integer basketAmount;

    @Column(name = "order_date")
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

    public Integer getBasketAmount() {
        return basketAmount;
    }

    public void setBasketAmount(Integer basketAmount) {
        this.basketAmount = basketAmount;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderDate(java.sql.Timestamp timestamp) {
    }
}
