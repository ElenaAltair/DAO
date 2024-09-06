package ru.netology.dao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.dao.model.OrdersCustomer;
import ru.netology.dao.model.ProductCustomer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JdbcRepository {

    private String sqlString;
    private String allOrdersSqlString;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        sqlString = read("myScript.sql");
        allOrdersSqlString = read("AllOrders.sql");
    }

    public List<ProductCustomer> getProductName(String name) {
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

    public List<OrdersCustomer> getInfoAllOrders() {
        List<OrdersCustomer> ordersCustomers = namedParameterJdbcTemplate.query(
            allOrdersSqlString,
                (rs, rowNum) -> new OrdersCustomer(
                        rs.getInt("id"),
                        rs.getDate("date"),
                        rs.getString("product_name"),
                        rs.getInt("amount"),
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("age"),
                        rs.getString("phone_number")
                ));

        return ordersCustomers;
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
