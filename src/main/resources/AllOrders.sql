select o.id, o.date, o.product_name, o.amount, c.id, c.name, c.surname, c.age, c.phone_number
from netology.ORDERS as o
         inner join netology.customers as c on c.id = o.customer_id
order by o.date