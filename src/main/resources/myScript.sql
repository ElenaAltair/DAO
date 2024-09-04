select o.id, o.product_name, c.id, c.name
from public.orders o
    inner join public.customers as c on c.id = o.customers_id
    where lower(c.name) = lower(:name)
