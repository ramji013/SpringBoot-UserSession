drop table user;
drop table users_roles;
create table user (id bigint auto_increment,name varchar2(30), email varchar2(50), user_name varchar2(10), password varchar2(15));
create table users_roles (role_id bigint auto_increment,user_id varchar2(10) ,role varchar2(10));

insert into user values(0, 'Ram', 'ram@gmail.com', 'ramji013', '123');
insert into users_roles values(1,0, 'ADMIN');