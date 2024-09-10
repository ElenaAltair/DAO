insert into netology.CUSTOMERS (name, surname, age, phone_number)
values  ('Vladimir', 'Sidorov', 27, '+7(123)999-99-99'),
        ('Petr', 'Smirnov', 30, '+7(356)888-88-88'),
        ('Oleg', 'Seleznev', 18, '+7(458)777-77-77'),
        ('Alexey', 'Romanov', 20, '+7(222)555-55-55');
insert into netology.ORDERS (date, customer_id, product_name, amount)
values  ('2021-09-01', 1, 'sofe', 1),
        ('2021-09-23', 3, 'table', 1),
        ('2021-09-07', 1, 'table', 2),
        ('2021-09-10', 4, 'lamp', 10),
        ('2021-09-23', 2, 'lamp', 3),
        ('2021-09-22', 4, 'car', 2);