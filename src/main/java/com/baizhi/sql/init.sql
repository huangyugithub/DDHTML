-----------1.管理员表--------------
create table dd_admin  (
   admin_id             NUMBER(5)                       not null,
   admin_password       VARCHAR2(30),
   admin_name           VARCHAR2(30),
   admin_username       VARCHAR2(30),
   constraint PK_DD_ADMIN primary key (admin_id)
);
drop table dd_admin
insert into dd_admin values(1,'123456','黄宇','hy');
select * from dd_admin where admin_username = 'hy' and admin_password = '123456'
---------------2.用户表-------------
create table dd_user  (
   user_id              NUMBER(5)                       not null,
   user_eamil           VARCHAR2(30),
   user_password        VARCHAR2(30),
   user_status          VARCHAR2(30),
   user_name            VARCHAR2(30),
   user_ukey            VARCHAR2(30),
   user_joindate        DATE,
   constraint PK_DD_USER primary key (user_id)
);
alter table dd_user rename column 原列名 to 新列名
alter table 表名 modify 列名 （新）数据类型约束

alter table dd_user modify user_ukey varchar2(40)

select * from dd_user
drop table dd_user
insert into dd_user values(dd_user_seq.nextval,'237746309@qq.com','123456','正常','黄宇','abcdefg',sysdate)
insert into dd_user values(dd_user_seq.nextval,'123@qq.com','123456','正常','呵呵','abcdefg',to_date('2019-12-20','YYYY-MM-DD'))

insert into dd_user values(dd_user_seq.nextval,'1234@qq.com','123456','正常','呵呵','123456789123456789123456789000123456',to_date('2019-12-20','YYYY-MM-DD'))


------------创建用户表id序列--------
create sequence dd_user_seq  start with  10000
select dd_user_seq.nextval from dual
drop  sequence dd_user_seq

--------------3.地址表-------------
create table dd_address  (
   address_id           NUMBER(5)                       not null,
   dd__user_id          NUMBER(5),
   address_name         VARCHAR2(300),
   address_zip          NUMBER(10),
   address_telephone    NUMBER(13),
   address_phone        NUMBER(11),
   constraint PK_DD_ADDRESS primary key (address_id)
);
alter table dd_address modify address_telephone varchar2(13);
alter table dd_address modify address_phone varchar2(12);
select * from dd_address

insert into dd_address values(1001,10004,'北京天安门',037003,'12345678910','0352-1234567');
insert into dd_address values(1002,10004,'山西省太原市',037003,'12345678910','0351-1234567');
------------创建地址表id序列--------
create sequence dd_address_seq  start with  1
select dd_address_seq.nextval from  dual
drop  sequence dd_address_seq

alter table dd_address
   add constraint FK_DD_ADDRE_REFERENCE_DD_USER foreign key (dd__user_id)
      references dd_user (user_id);

--------------4.订单表---------------
create table dd_order  (
   order_id             NUMBER(30)                      not null,
   user_id              NUMBER(5),
   address_id           NUMBER(5),
   order_num            NUMBER(30),
   order_totalprice     NUMBER(8,2),
   order_user           VARCHAR2(15),
   order_address        VARCHAR2(150),
   order_creationtime   DATE,
   order_status         VARCHAR2(30),
   constraint PK_DD_ORDER primary key (order_id)
);
alter table dd_order modify order_id number(30)
alter table dd_order modify order_num varchar2(40)

select * from dd_order order by order_id
delete from dd_order

alter table dd_order
   add constraint FK_DD_ORDER_REFERENCE_DD_USER foreign key (user_id)
      references dd_user (user_id);

alter table dd_order
   add constraint FK_DD_ORDER_REFERENCE_DD_ADDRE foreign key (address_id)
      references dd_address (address_id);
----------创建订单id---------------------
drop  sequence order_id_seq
create sequence order_id_seq start with 4001
select order_id_seq.nextval from  dual


-------------------5.购物车项详情表-----------------------

create table dd_caritem  (
   shopcar_id           NUMBER(5)                       not null,
   order_id             NUMBER(30),
   product_id           NUMBER(5),
   shopcar_totalprice   NUMBER(8,2),
   shopcar_satus        VARCHAR(15),
   shopcar_smalltatal   NUMBER(8,2),
   shopcar_counts       NUMBER(5),
   constraint PK_DD_CARITEM primary key (shopcar_id)
);
alter table 表名 modify 列名 （新）数据类型约束
alter table dd_caritem modify shopcar_id number(5)

select * from dd_caritem where order_id = 4006 order by shopcar_id
delete from dd_caritem
select c.*,p.* from dd_caritem c inner join dd_product p 
on c.product_id = p.product_id 
where c.order_id = 4006

select c.*,p.product_id,p.prodct_name,p.prduct_price,p.prduct_ddprice,p.prduct_cover from dd_caritem c inner join dd_product p 
			on c.product_id = p.product_id 
			where c.order_id = 4006

alter table dd_caritem
   add constraint FK_DD_CARIT_REFERENCE_DD_ORDER foreign key (order_id)
      references dd_order (order_id);

alter table dd_caritem
   add constraint FK_DD_CARIT_REFERENCE_DD_PRODU foreign key (product_id)
      references dd_product (product_id);
------------------购物项主键id-------------------------
drop  sequence shopcar_id_seq
create sequence shopcar_id_seq start with 1
select shopcar_id_seq.nextval from  dual

select * from dd_caritem order by shopcar_id

comment on table dd_caritem is
'购物项详情表
';

comment on column dd_caritem.shopcar_id is
'购物车id';

comment on column dd_caritem.order_id is
'订单id';

comment on column dd_caritem.shopcar_totalprice is
'订单总金额';

comment on column dd_caritem.shopcar_satus is
'订单状态';

comment on column dd_caritem.shopcar_smalltatal is
'商品的小计';

comment on column dd_caritem.shopcar_counts is
'商品的数量';


------------------6.类别表-------------------
create table dd_category  (
   category_id          NUMBER(5)                       not null,
   dd__category_id      NUMBER(5),
   category_name        VARCHAR2(15),
   category_byclass     NUMBER(5),
   category_class       NUMBER(5),
   constraint PK_DD_CATEGORY primary key (category_id)
);

alter table dd_category
   add constraint FK_DD_CATEG_REFERENCE_DD_CATEG foreign key (dd__category_id)
      references dd_category (category_id);

select * from dd_category
delete from dd_category
insert into dd_category values(1001,null,'小说',null,1);
insert into dd_category values(1002,null,'科技',null,1);
insert into dd_category values(1003,null,'教育',null,1);
insert into dd_category values(1004,1001,'古典小说',1,2);
insert into dd_category values(1005,1001,'近现代小说',1,2);


-----------------类别表主键序列----------------
drop  sequence  category_id_seq
create sequence  category_id_seq start with 1005
select  category_id_seq.nextval from  dual

comment on table dd_category is
'当当1级 2级类别表';

comment on column dd_category.category_id is
'类别id';

comment on column dd_category.dd__category_id is
'类别id';

comment on column dd_category.category_name is
'类别的名字';

comment on column dd_category.category_byclass is
'所属类别';

comment on column dd_category.category_class is
'1级类别id';

-----------------7.商品表---------------------
create table dd_product  (
   product_id           NUMBER(5)                       not null,
   category_id          NUMBER(5),
   prodct_name          VARCHAR2(300),
   prduct_price         NUMBER(5,2),
   prduct_ddprice       NUMBER(5,2),
   product_counts       NUMBER(5),
   prduct_author        VARCHAR2(300),
   prduct_publisher     VARCHAR2(300),
   prduct_publishtime   DATE,
   prduct_printtime     DATE,
   prduct_ISBN          NUMBER(10),
   prduct_salescount    NUMBER(10),
   prduct_format        VARCHAR2(300),
   prduct_paper         VARCHAR2(300),
   prduct_packaging     VARCHAR2(300),
   prduct_pages         NUMBER(10),
   prduct_words         NUMBER(10),
   prduct_cover         VARCHAR2(300),
   prduct_bjtj          VARCHAR2(300),
   prduct_nrjs          VARCHAR2(600),
   prduct_zzjs          VARCHAR2(300),
   prduct_jbml          VARCHAR2(600),
   prduct_comments      VARCHAR2(600),
   constraint PK_DD_PRODUCT primary key (product_id)
);
delete dd_product where product_id = 2
insert into dd_product values(1,1004,'三国演义',80.5,50.0,62,'曹雪芹','北京新华出版社',to_date('2007-12-20','YYYY-MM-DD'),
 to_date('2007-12-01','YYYY-MM-DD'),1234567,31,'32开','二号凸版纸','双语包装',300,800000,'/back/img/sgyy.jpg',
 '一本好书','清代贾府的兴衰起落','曹雪芹，名沾，字梦阮，号雪芹，又号芹溪、芹圃，中国古典名著《红楼梦》的作者','74章','媒体评论');
 insert into dd_product values(2,1004,'红楼梦',80.5,50.0,62,'曹雪芹','北京新华出版社',to_date('2007-12-20','YYYY-MM-DD'),
 to_date('2007-12-01','YYYY-MM-DD'),1234567,31,'32开','二号凸版纸','双语包装',300,800000,'/back/img/hlm.jpg',
 '一本好书','清代贾府的兴衰起落','曹雪芹，名沾，字梦阮，号雪芹，又号芹溪、芹圃，中国古典名著《红楼梦》的作者','74章','媒体评论');
 insert into dd_product values(3,1004,'红楼梦',80.5,50.0,62,'曹雪芹','北京新华出版社',to_date('2007-12-20','YYYY-MM-DD'),
 to_date('2007-12-01','YYYY-MM-DD'),1234567,31,'32开','二号凸版纸','双语包装',300,800000,'img/xxx/xxx',
 '一本好书','清代贾府的兴衰起落','曹雪芹，名沾，字梦阮，号雪芹，又号芹溪、芹圃，中国古典名著《红楼梦》的作者','74章','媒体评论');
 insert into dd_product values(4,1004,'红楼梦',80.5,50.0,62,'曹雪芹','北京新华出版社',to_date('2007-12-20','YYYY-MM-DD'),
 to_date('2007-12-01','YYYY-MM-DD'),1234567,31,'32开','二号凸版纸','双语包装',300,800000,'img/xxx/xxx',
 '一本好书','清代贾府的兴衰起落','曹雪芹，名沾，字梦阮，号雪芹，又号芹溪、芹圃，中国古典名著《红楼梦》的作者','74章','媒体评论');
insert into dd_product values(5,1004,'红楼梦',80.5,50.0,62,'曹雪芹','北京新华出版社',to_date('2007-12-20','YYYY-MM-DD'),
 to_date('2007-12-01','YYYY-MM-DD'),1234567,31,'32开','二号凸版纸','双语包装',300,800000,'img/xxx/xxx',
 '一本好书','清代贾府的兴衰起落','曹雪芹，名沾，字梦阮，号雪芹，又号芹溪、芹圃，中国古典名著《红楼梦》的作者','74章','媒体评论');


select category_id,count(*) from dd_product where category_id in (
			select category_id from dd_category where dd__category_id = 1001
		)group by category_id



select * from (select p.*,rownum as rn from (select * from dd_product where category_id 
		in(select category_id from dd_category where dd__category_id = 1001) ) p) 
		where rn between 1 and 3

select count(*) from (select * from dd_product where category_id 
		in(select category_id from dd_category where dd__category_id = 1001) )


select count(*) from  dd_product where category_id 
				in(select category_id from dd_category where dd__category_id = 1001) 
				


select * from (select * from dd_product order by prduct_publishtime desc) where rownum < 3
select * from dd_product where to_char(prduct_publishtime,'q')=to_char(sysdate,'q') order by prduct_publishtime
		

select * from dd_product where prduct_publishtime between sysdate-30 and sysdate

select * from dd_product where category_id in(select category_id from dd_category where dd__category_id = 1001)


select * from dd_product where prodct_name like '%梦%'
select count(*) from dd_product
select * from dd_product
select * from (select p.*,rownum as rn from dd_product p) 
		where rn between 3 and 4
alter table dd_product
   add constraint FK_DD_PRODU_REFERENCE_DD_CATEG foreign key (category_id)
      references dd_category (category_id);
      
-----------------创建商品表主键序列----------------
drop  sequence  product_id_seq
create sequence  product_id_seq start with 10000


select product_id_seq.nextval from dual

select  * from  dd_product
comment on table dd_product is
'商品表';

comment on column dd_product.category_id is
'类别id';

