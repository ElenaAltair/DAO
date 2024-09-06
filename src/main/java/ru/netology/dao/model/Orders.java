package ru.netology.dao.model;

import java.util.Date;

public class Orders {
    private int id;
    private Date date;
    private int customerId;
    private String productName;
    private int amount;

    public Orders() {
    }

    public Orders(int id, Date date, int customerId, String productName, int amount) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
        this.productName = productName;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                ", customer_id=" + customerId +
                ", product_name='" + productName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
