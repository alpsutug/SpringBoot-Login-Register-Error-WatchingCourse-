package com.simpleform.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_table")
public class ProductModel {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name =  "product_seq", sequenceName =  "product_seq", allocationSize = 1)
    Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_explanation")
    private String productExplanation;

    @Column(name = "product_price")
    private int productPrice;

    @Column(name = "product_stock_amount")
    private int productStockAmount;

    @Column(name = "product_category")
    private String productCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductExplanation() {
        return productExplanation;
    }

    public void setProductExplanation(String productExplanation) {
        this.productExplanation = productExplanation;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStockAmount() {
        return productStockAmount;
    }

    public void setProductStockAmount(int productStockAmount) {
        this.productStockAmount = productStockAmount;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}
