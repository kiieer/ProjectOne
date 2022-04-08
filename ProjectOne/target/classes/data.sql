create table employees (
id serial primary key, username varchar(30), pass varchar(30));

create table managers (
id serial primary key, username varchar(30), pass varchar(30));


create table reimbursements (
id serial primary key,
emp_id integer,
man_id integer,
type varchar,
amount numeric, 
description varchar(30),
submit timestamp not null default CURRENT_TIMESTAMP,
resolve_time timestamp default CURRENT_TIMESTAMP,
resolved boolean,
accepted boolean,
foreign key (emp_id) references employees(id),
foreign key (man_id) references managers(id)
);