/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom08.bookstore.Models;

import java.text.DecimalFormat;

/**
 *
 * @author Quoc Thinh
 */
public class ModelItemSell {

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ModelItemSell(String productId, String productName, int qty, double price, double total) {
        this.productId = productId;
        this.productName = productName;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }

    public ModelItemSell() {
    }

    private String productId;
    private String productName;
    private int qty;
    private double price;
    private double total;

    public Object[] toTableRow(int rowNum) {
        DecimalFormat df = new DecimalFormat("#,###");
        return new Object[]{df.format(rowNum), productName, df.format(qty),df.format(price), df.format(total)};
    }
}
