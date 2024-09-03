--liquibase formatted sql

--changeset petrova:03
create table if not exists netology.ORDERS (
     id serial primary key,
     date date not null,
     customer_id serial NOT NULL,
     product_name text NOT NULL,
     amount int NOT NULL,
     FOREIGN KEY (customer_id) REFERENCES netology.CUSTOMERS (id)
    )
--rollback drop table netology.ORDERS;