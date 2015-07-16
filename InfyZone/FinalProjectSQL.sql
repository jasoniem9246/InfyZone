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

--Image url 

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://i01.i.aliimg.com/wsphoto/v3/1302316597_1/2015-fashion-lace-up-cool-brown-tan-dress-shoes-man-casual-business-shoes-safety-genuine-leather.jpg'
WHERE PRODUCT_NAME ='Mens Shoes'; 

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://www.bestpassportwallet.com/wp-content/uploads/2011/03/saddleback_leather_passport_wallet-300x300.jpg'
WHERE PRODUCT_NAME = 'Wallet';

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://i.ebayimg.com/00/s/NjUwWDY1MA==/$(KGrHqZHJBwE8+7+)4k,BPVoFcjEfg~~60_35.JPGWHERE'
PRODUCT_NAME = 'Business Shirt';

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://g04.a.alicdn.com/kf/HTB1Ra7EHVXXXXceXFXXq6xXFXXXa/Free-shipping-2015-new-arrival-slim-font-b-suit-b-font-pants-men-formal-wear-business.jpg'
WHERE PRODUCT_NAME = 'Trousers';

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://ecx.images-amazon.com/images/I/81vJvGZg%2BrL._UL1500_.jpg'
WHERE PRODUCT_NAME = 'Jacket';

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://vfimages.comtoolsonline.com/comtoolsimages/Zoom/PS_RK_SE43LB_F.jpg'
WHERE PRODUCT_NAME = 'Blouse';

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://g04.a.alicdn.com/kf/HTB1AUhpIXXXXXcJXFXXq6xXFXXX3/880-Bustier-Black-Fashion-business-suit-strapless-Black-striped-Boned-Busk-Bustier-Corset-Skirt.jpg'
WHERE PRODUCT_NAME = 'Skirt';

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://www.nextavenue.org/wp-content/uploads/2015/05/violet.jpg'
WHERE PRODUCT_NAME = 'Ladies Shoes';

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://cdn3.volusion.com/luyxe.dexsa/v/vspfiles/photos/40mmLBlkDblLoop2686GovBlkSnap-2.jpg '
WHERE PRODUCT_NAME = 'Belt';

UPDATE DEMO_PRODUCT_INFO
SET PRODUCTIMAGEURL = 'http://imgs.inkfrog.com/pix/vipcouture/DSC_0892_005.JPG'
WHERE PRODUCT_NAME = 'Bag';

