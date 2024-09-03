package ru.netology.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao.model.ProductCustomer;
import ru.netology.dao.repository.Repository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    Repository repository;

    @GetMapping("/products/fetch-product")
    public List<ProductCustomer> getProduct(@Valid String name) {
        return repository.getProductName(name);
    }
}
