package ru.netology.dao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.dao.model.Orders;
import ru.netology.dao.model.ProductCustomer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JdbcRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private String sqlString;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        sqlString = read("myScript.sql");
    }

    public List<ProductCustomer> getProductName(String name) {

        List<Orders> orders = entityManager.createQuery(
                        "select o from Orders o inner join Customers as c on c.id = o.customers.id where lower(c.name) = lower(:name)", Orders.class)
                .setParameter("name", name)
                .getResultList();

        List<ProductCustomer> productCustomers = new ArrayList<>();
        for (Orders order : orders) {
            productCustomers.add(new ProductCustomer(order.getId(), order.getProduct_name(), order.getCustomers().getId(), order.getCustomers().getName()));
        }

        /*
        List<ProductCustomer> productCustomer = namedParameterJdbcTemplate.query(
                sqlString,
                Collections.singletonMap("name", name),
                (rs, rowNum) -> new ProductCustomer(
                        rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getInt("id"),
                        rs.getString("name")
                ));
        */

        return productCustomers;
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
