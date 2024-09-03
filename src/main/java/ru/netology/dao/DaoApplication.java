package ru.netology.dao;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.netology.dao.model.ProductCustomer;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class DaoApplication{ // implements CommandLineRunner

    /*
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DaoApplication(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    */

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DaoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    /*
    @Override
    public void run(String... args) throws SQLException {

        //Выполним запрос с помощью NamedParameterJdbcTemplate
        List<ProductCustomer> productCustomer = namedParameterJdbcTemplate.query(
                "select o.id, o.product_name, c.id, c.name from netology.ORDERS as o inner join netology.customers as c on c.id = o.customer_id",
                (rs, rowNum) -> new ProductCustomer(
                        rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getInt("id"),
                        rs.getString("name")
                ));

        productCustomer.forEach(System.out::println);

    }
    */

}

