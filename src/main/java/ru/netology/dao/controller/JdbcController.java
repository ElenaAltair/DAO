package ru.netology.dao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao.model.ProductCustomer;
import ru.netology.dao.repository.JdbcRepository;

import java.util.List;

@RestController
public class JdbcController {

    private JdbcRepository jdbcRepository;

    public JdbcController(JdbcRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    @GetMapping("/products/fetch-product")
    public List<ProductCustomer> getProduct(String name) {
        return jdbcRepository.getProductName(name);
    }
}
