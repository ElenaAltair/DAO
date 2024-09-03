package ru.netology.dao.model;

public class ProductCustomer {
    private int idOrder;
    private String productName;
    private int customerId;
    private String customerName;

    public ProductCustomer() {
    }

    public ProductCustomer(int idOrder, String productName, int customerId, String customerName) {
        this.idOrder = idOrder;
        this.productName = productName;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "ProductCustomer{" +
                "idOrder=" + idOrder +
                ", productName='" + productName + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
