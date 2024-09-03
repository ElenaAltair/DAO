select o.id, o.product_name, c.id, c.name
from netology.ORDERS as o
    inner join netology.customers as c on c.id = o.customer_id
    where lower(c.name) = lower(:name)
