create table student(
stu_no int not null,
stu_name varchar(12) not null,
stu_year int not null,
stu_addr varchar(100) not null,
stu_tel varchar(20) not null,
stu_birth date,
primary key(stu_no)
)default charset=utf8;

create table grade(
stu_no int not null,
grade_kor int not null,
grade_eng int not null,
grade_math int not null,
primary key(stu_no),
constraint grade_stu_no_fk
FOREIGN KEY (`stu_no`) REFERENCES `student` (`stu_no`) on delete cascade
)default charset=utf8;

insert into student values(20170001, '김나라', 2, '서울특별시 강남구', '011-222-1111', '2001-05-05'),
(20170002, '오필승', 2, '대구광역시 동구', '010-555-2365', '2001-12-24'),
(20180001, '오판석', 1, '경상남도 창원시', '010-878-7979', '2002-03-09');

insert into grade values(20170001, 90, 89, 90),
(20170002, 57, 68, 82),
(20180001, 100, 75, 97);

select * from student;
select * from grade;