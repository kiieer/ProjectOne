create table employees (
id serial primary key, username varchar(255), pass varchar(255), emptype varchar(255));

create table reimbursements (
id serial primary key,
emp_id integer,
man_id integer,
type varchar,
amount numeric, 
description varchar(30),
submit timestamp not null default CURRENT_TIMESTAMP,
resolve_time date,
resolved boolean,
accepted boolean,
foreign key (emp_id) references employees(id)
);