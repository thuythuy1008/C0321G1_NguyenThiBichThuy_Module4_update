insert into position_empl (position_name)
values 
("Lễ tân"),
("Phục vụ"),
("Chuyên viên"),
("Giám sát"),
("Quản lý"),
("Giám đốc");

insert into education_degree (education_degree_name)
values
("Trung cấp"),
("Cao đẳng"),
("Đại học"),
("Sau đại học");

insert into division (division_name)
values
("Sale – Marketing"),
("Hành chính"),
("Phục vụ"),
("Quản lý");

-- insert into `role` (role_name)
-- values
-- ("admin"),
-- ("quản lý"),
-- ("nhân viên"),
-- ("giám đốc");

-- insert into `user`
-- values
-- ("ngoc123","123456"),
-- ("nhatthanh1","123456"),
-- ("kimdung1202","123456"),
-- ("dieumy123","123456"),
-- ("anhkhoa1008","123456");

-- insert into user_role
-- values
-- (1,"anhkhoa1008"),
-- (1,"nhatthanh1"),
-- (3,"ngoc123"),
-- (3,"kimdung1202"),
-- (2,"dieumy123");

-- insert into employee
-- values
-- (1,"Nguyễn Ngọc","1994/08/10","190273846",7000000,"0398579397","ngoc@gmail.com","Đà Nẵng",1,2,2,"ngoc123"),
-- (2,"Huỳnh Nhật Thành","1995/10/06","198538579",8000000,"0368036796","nhatthanh@gmail.com","Huế",3,3,1,"nhatthanh1"),
-- (3,"Kim Dung","1992/12/20","194079780",9000000,"0987064679","kimdung@gmail.com","Quảng Trị",5,3,4,"kimdung1202"),
-- (4,"Trần Diệu My","1997/01/25","197490876",6000000,"0393908790","my@gmail.com","Kon Tum",2,1,3,"dieumy123"),
-- (5,"Đỗ Anh Khoa","1990/05/18","190985098",10000000,"0392076068","khoa@gmail.com","Hà Nội",4,4,2,"anhkhoa1008");

insert into employee (employee_id,employee_name, employee_birthday, employee_id_card, employee_salary, 
employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id)
values
(1,"Nguyễn Ngọc","1994/08/10","190273846",7000000,"0398579397","ngoc@gmail.com","Đà Nẵng",1,2,2),
(2,"Huỳnh Nhật Thành","1995/10/06","198538579",8000000,"0368036796","nhatthanh@gmail.com","Huế",3,3,1),
(3,"Kim Dung","1992/12/20","194079780",9000000,"0987064679","kimdung@gmail.com","Quảng Trị",5,3,4),
(4,"Trần Diệu My","1997/01/25","197490876",6000000,"0393908790","my@gmail.com","Kon Tum",2,1,3),
(5,"Đỗ Anh Khoa","1990/05/18","190985098",10000000,"0392076068","khoa@gmail.com","Hà Nội",4,4,2);

insert into customer_type (customer_type_name)
values
("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member");

insert into customer (customer_id, customer_code, customer_name, customer_birthday, customer_gender, 
customer_id_card, customer_phone, customer_email, customer_address, customer_type_id)
values
(1,"KH-0001","Mai An","1993/04/12",1,"190263074","0987654309","an@gamil.com","Gia Lai",1),
(2,"KH-0002","Trương Văn Lâm","1996/02/22",0,"198346228","0927394796","lam@gamil.com","Phan Thiết",4),
(3,"KH-0003","Võ Tuấn Tú","1989/06/02",0,"190980987","0982019374","tu@gamil.com","Hải Phòng",3),
(4,"KH-0004","Lê Duyên","1993/08/10",1,"190980463","0987090479","duyen@gamil.com","Hà Tĩnh",5),
(5,"KH-0005","Trần Anh Kiệt","1990/11/23",0,"190002839","0987253849","kiet@gamil.com","Hồ Chí Minh",2);

insert into service_type(service_type_name)
values  
("Thường"),
("Vip");

insert into rent_type (rent_type_id, rent_type_name, rent_type_cost)
values 
(1,"Ngày",300000),
(2,"Tuần",1000000),
(3,"Tháng",2500000);

insert into service (service_code,service_name,service_area,service_cost,service_max_people,standard_room,
description_other_convenience,pool_area,number_of_floors,service_type_id,rent_type_id)
values
("DV-0001","Villa1",40,10000000,12,"Rộng rãi","Thoáng mát",30,3,2,2),
("DV-0002","Villa2",50,12000000,15,"Rộng rãi","Thoáng mát",35,3,1,3);
insert into service (service_code,service_name,service_area,service_cost,service_max_people,standard_room,
description_other_convenience,number_of_floors,service_type_id,rent_type_id)
values
("DV-0003","House1",30,8000000,8,"Rộng rãi","Thoáng mát",2,1,1),
("DV-0004","House2",40,10000000,10,"Rộng rãi","Thoáng mát",3,2,2);
insert into service (service_code,service_name,service_area,service_cost,service_max_people,service_type_id,rent_type_id)
values
("DV-0005","Room1",25,5000000,6,2,1),
("DV-0006","Room2",20,4000000,4,1,3);

insert into contract (contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, 
employee_id, customer_id, service_id)
values
(1,"2020/03/15","2020/03/22",3000000,0,1,2,1),
(2,"2020/05/10","2020/06/10",4000000,0,2,5,2),
(3,"2020/08/01","2020/08/02",5000000,0,5,1,3),
(4,"2020/11/20","2020/11/27",3000000,0,3,3,4),
(5,"2020/12/18","2020/12/19",2000000,0,4,4,5);

insert into attach_service (attach_service_id, attach_service_name, attach_service_cost, attach_service_unit, 
attach_service_status)
values
(1,"Massage",500000,1,"Mở"),
(2,"Karaoke",700000,1,"Mở"),
(3,"Thức ăn",500000,1,"Mở"),
(4,"Nước uống",200000,1,"Mở"),
(5,"Xe thuê",400000,1,"Mở");

insert into contract_detail (contract_detail_id, contract_id, attach_service_id, quantity)
values
(1,1,2,1),
(2,2,4,1),
(3,3,1,1),
(4,4,5,1),
(5,5,3,1);