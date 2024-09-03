package ru.netology.dao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.netology.dao.model.ProductCustomer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Repository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<ProductCustomer> getProductName(String name){
        String sqlString = read("myScript.sql");

        List<ProductCustomer> productCustomer = namedParameterJdbcTemplate.query(
                sqlString,
                Collections.singletonMap("name", name),
                (rs, rowNum) -> new ProductCustomer(
                        rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getInt("id"),
                        rs.getString("name")
                ));
        return productCustomer;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
