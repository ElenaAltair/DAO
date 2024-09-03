create schema if not exists netology;

create table if not exists netology.CUSTOMERS (
    id serial primary key,
    name varchar(200) not null,
    surname varchar(200) not null,
    age int NOT NULL,
    phone_number varchar(200) NOT NULL
   );

create table if not exists netology.ORDERS (
    id serial primary key,
    date date not null,
    customer_id serial NOT NULL,
    product_name text NOT NULL,
    amount int NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES netology.CUSTOMERS (id)
    );

--insert into netology.CUSTOMERS (name, surname, age, phone_number)
--values  ('Vladimir', 'Sidorov', 27, '+7(123)999-99-99'),
--        ('Petr', 'Smirnov', 30, '+7(356)888-88-88'),
--        ('Oleg', 'Seleznev', 18, '+7(458)777-77-77'),
--        ('Alexey', 'Romanov', 20, '+7(222)555-55-55');

--insert into netology.ORDERS (date, customer_id, product_name, amount)
--values  ('2021-09-01', 1, 'sofe', 1),
--        ('2021-09-23', 3, 'table', 1),
--        ('2021-09-07', 1, 'table', 2),
--        ('2021-09-10', 4, 'lamp', 10),
--        ('2021-09-23', 2, 'lamp', 3),
--        ('2021-09-22', 4, 'car', 2);