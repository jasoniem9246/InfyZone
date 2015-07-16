--ALTER Table Schema
ALTER TABLE DEMO_USERS
ADD USER_EMAIL VARCHAR2(30)

ALTER TABLE DEMO_CUSTOMERS
DROP COLUMN CUST_EMAIL

ALTER TABLE DEMO_CUSTOMERS
ADD USER_ID NUMBER(22) CONSTRAINT user_id_fk references DEMO_USERS(USER_ID);

ALTER TABLE DEMO_PRODUCT_INFO
ADD productImageURL VARCHAR2(400)

ALTER TABLE demo_order_items 
MODIFY order_item_id number(22,0);


-- Update Table
update DEMO_USERS
set USER_EMAIL = 'infy@gmail.com',
password = '123456'
where USER_ID = 1


update DEMO_PRODUCT_INFO
set PRODUCTIMAGEURL = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNEoggV9IST9JRx42osI5tBC_uWoi6oLYxvKl0yGRtv-w1m8yV'
where PRODUCT_ID= 9;


update demo_customers
set user_id = 1
where customer_id = 1

