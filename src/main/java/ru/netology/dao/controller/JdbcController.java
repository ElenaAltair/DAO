package ru.netology.dao.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao.model.Customers;
import ru.netology.dao.model.Orders;
import ru.netology.dao.model.OrdersCustomer;
import ru.netology.dao.model.ProductCustomer;
import ru.netology.dao.repository.JdbcRepository;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
public class JdbcController {

    private JdbcRepository jdbcRepository;

    public JdbcController(JdbcRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    @GetMapping("/products/customers") // http://localhost:8080/products/customers
    @Secured("ROLE_READ")
    public List<Customers> getCustomers() {
        return jdbcRepository.getCustomers();
    }

    @GetMapping("/products/all-orders") // http://localhost:8080/products/all-orders
    @RolesAllowed("ROLE_WRITE") //
    public List<OrdersCustomer> getAllOrders() {
        return jdbcRepository.getInfoAllOrders();
    }

    @GetMapping("/products/orders") // http://localhost:8080/products/orders
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public List<Orders> getOrders() {
        return jdbcRepository.getOrders();
    }

    @GetMapping("/products/fetch-product") // http://localhost:8080/products/fetch-product?name=vladimir
    @PostAuthorize("returnObject.get(0).customerName.toLowerCase() == authentication.principal.username")
    public List<ProductCustomer> getProduct(@Valid String name) {
        return jdbcRepository.getProductName(name);
    }

    @GetMapping("/products/customer-name") // http://localhost:8080/products/customer-name?name=vladimir
    @PostAuthorize("returnObject.toString() == authentication.principal.username")
    public String getCustomerName(String name) {
        return jdbcRepository.getCustomersName(name);
    }

}
