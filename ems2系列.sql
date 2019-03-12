--管理员表M_USER
CREATE TABLE M_USER(
ID VARCHAR2(10) PRIMARY KEY,
NAME NVARCHAR2(20) UNIQUE,
REALNAME NVARCHAR2(20),
PASSWORD VARCHAR2(6),
SEX NUMBER(1)
)
--员工表M_EMPLOYEES
CREATE TABLE M_EMPLOYEES(
ID VARCHAR2(10) PRIMARY KEY,
NAME NVARCHAR2(20),
SALARY VARCHAR2(6),
AGE NUMBER(3),
DID VARCHAR2(10)
)
--部门表M_DEPATMENT
CREATE TABLE M_DEPARTMENT(
ID VARCHAR2(10) PRIMARY KEY,
NAME NVARCHAR2(20)
)

--2.2M_DEPARTMENTS
CREATE TABLE M_DEPARTMENTS(
ID VARCHAR2(10) PRIMARY KEY,
NAME NVARCHAR2(20),
NOTE NVARCHAR2(40)
)
-----------------
SELECT * FROM M_USER;
SELECT * FROM M_EMPLOYEES;
SELECT * FROM M_DEPARTMENT;
SELECT * FROM M_DEPARTMENTS;

CREATE SEQUENCE M_USER_SEQ START WITH 2;
CREATE SEQUENCE M_DEP_SEQ START WITH 1006;

DROP  SEQUENCE M_DEP_SEQ
DROP TABLE  M_DEPARTMENTS

--M_USER
INSERT INTO M_USER VALUES('1','Ella','Mei','123456',0);
--M_EMPLOYEES
INSERT INTO M_EMPLOYEES VALUES('1','黛玉','5000',0,'1001');
--M_DEPARTMENT
INSERT INTO M_DEPARTMENT VALUES('1001','编辑部');
--M_DEPARTMENTS
INSERT INTO M_DEPARTMENTS VALUES(M_DEP_SEQ.NEXTVAL,'编辑部','编辑文档资料');


CREATE SEQUENCE M_USER_SEQ START WITH 2;
CREATE SEQUENCE M_EMP_SEQ START WITH 1006;

--------------

select d.* from 
(select id,name,note ,rownum rw 
from m_departments where rownum<=4 and name like '%*%')d
where rw between 1 and 3;

select count(*) from  m_departments where name like '%*%'


select id,name,note from m_departments

update m_departments
set name='人力资源部',note='发展下线'
where id=1001

select d.* from
(select e.id id,e.name,e.salary,e.age,p.id pid,p.name pname,
rownum rw 
from m_employees e join m_departments p
on e.did=p.id
where rownum <=3 and p.id=1004)d
where rw between 1 and 2

select count(*) from m_employees where did=1004


select count(*) from  m_departments;

select d.* from 
(select id,name,note ,rownum rw 
from m_departments where rownum<4)d
where rw between 2 and 3;


insert into m_employees values(M_USER_SEQ.NEXTVAL,name,salary,age,did)

select id,name from m_department;

select e.name,e.salary,e.age,d.name dname
from m_employees e join m_department d
on e.did=d.id
where e.id='2';

drop table m_user

update  m_employees set name='黛玉',salary='5500',age=18,did='1001' where id='1';

select id,name,realname,password,sex 
from m_user
where id='1' and password='123456'

insert into m_user values(M_USER_SEQ.NEXTVAL,'小螃蟹','涛','123456',1);

select e.id id,e.name,e.salary,e.age,d.id pid,d.name dname
from m_employees e join m_department d
on e.did=d.id

delete from m_employees where id=1

select e.id id,e.name,e.salary,e.age,d.id pid,d.name dname
from m_employees e join m_department d
on e.did=d.id order by id
where e.name like '%'||#{str}||'%'

select count(*) from m_employees;

select d.* from
(select e.id id,e.name,e.salary,e.age,d.id pid,d.name dname,
rownum rw 
from m_employees e join m_department d 
on e.did=d.id 
where rownum <=3)d
where rw between 1 and 4 ;

select d.* from
(select e.id id,e.name,e.salary,e.age,d.id pid,d.name dname,
rownum rw 
from m_employees e join m_department d
on e.did=d.id
where rownum <=#{pb.end})d
where rw between #{pb.begin} and #{pb.end}
