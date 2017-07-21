create database Employee
use Employee
create table Emp
(
	empno varchar(20),
	empfn varchar(10),
	empmn varchar(10),
	empln varchar(10),
	empage int,
	empgen char,
	emphb varchar(10),
	empqual int,
)
insert into Emp values('E001','Jahanvi','Haresh','Jasani','19','F','1;2','2')
insert into Emp values('E002','Harsh','Haresh','Jasani','15','M','2;3','1')
insert into Emp values('E003','Jigna','Haresh','Jasani','45','F','2;3','2')
insert into Emp values('E004','Haresh','B','Jasani','50','M','2;3','3')
insert into Emp values('E005','H','B','Jasani','50','M','2;3','3')
select * from Emp