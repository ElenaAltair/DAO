package ru.netology.dao.model;

import java.util.Date;

public class OrdersCustomer {
    private int idOrder;
    private Date date;
    private String product_name;
    private int amount;
    private int idCustomer;
    private String nameCustomer;
    private String surnameCustomer;
    private int ageCustomer;
    private String phoneNumberCustomer;

    public OrdersCustomer() {}

    public OrdersCustomer(
            int idOrder,
            Date date,
            String product_name,
            int amount,
            int idCustomer,
            String nameCustomer,
            String surnameCustomer,
            int ageCustomer,
            String phoneNumberCustomer) {
        this.idOrder = idOrder;
        this.date = date;
        this.product_name = product_name;
        this.amount = amount;
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.surnameCustomer = surnameCustomer;
        this.ageCustomer = ageCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public int getId() {
        return idOrder;
    }

    public void setId(int id) {
        this.idOrder = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getSurnameCustomer() {
        return surnameCustomer;
    }

    public void setSurnameCustomer(String surnameCustomer) {
        this.surnameCustomer = surnameCustomer;
    }

    public int getAgeCustomer() {
        return ageCustomer;
    }

    public void setAgeCustomer(int ageCustomer) {
        this.ageCustomer = ageCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    @Override
    public String toString() {
        return "OrdersCustomer{" +
                "id=" + idOrder +
                ", date=" + date +
                ", product_name='" + product_name + '\'' +
                ", amount=" + amount +
                ", idCustomer=" + idCustomer +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", surnameCustomer='" + surnameCustomer + '\'' +
                ", ageCustomer=" + ageCustomer +
                ", phoneNumberCustomer='" + phoneNumberCustomer + '\'' +
                '}';
    }
}
