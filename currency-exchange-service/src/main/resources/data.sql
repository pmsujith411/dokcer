
create table exchange_value(id int,currency_from varchar(10),currency_to varchar(10),conversion_multiple int,port int)

insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port) values(1001,'USD','INR',65,0)
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port) values(1002,'CAD','INR',5,0)
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port) values(1001,'EUR','INR',95,0)