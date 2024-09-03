--liquibase formatted sql

--changeset petrova:02
create table if not exists netology.CUSTOMERS (
    id serial primary key,
    name varchar(200) not null,
    surname varchar(200) not null,
    age int NOT NULL,
    phone_number varchar(200) NOT NULL
    )
--rollback drop table netology.CUSTOMERS;