insert into Course(id,name,last_updated_date,created_date)
values(101,'JPA in 50 Steps',sysdate(),sysdate());
insert into Course(id,name,last_updated_date,created_date)
values(102,'Spring in 50 Steps',sysdate(),sysdate());
insert into Course(id,name,last_updated_date,created_date)
values(103,'Spring Boot in 100 Steps',sysdate(),sysdate());
insert into Course(id,name,last_updated_date,created_date)
values(104,'Hibernate in 100 Steps',sysdate(),sysdate());

insert into Passport(id,number)
values(401,'A132456');
insert into Passport(id,number)
values(402,'B123456');
insert into Passport(id,number)
values(403,'C123456');
insert into Passport(id,number)
values(404,'D123456');

insert into Student(id,name,passport_id)
values(201,'Himanshu',401);
insert into Student(id,name,passport_id)
values(202,'Rohidas',402);
insert into Student(id,name,passport_id)
values(203,'Vijaya',403);
insert into Student(id,name,passport_id)
values(204,'Hardik',404);

insert into Review(id,rating,description,course_id)
values(501,'5','Great Course',101);
insert into Review(id,rating,description,course_id)
values(502,'4','Wonderful Course',102);
insert into Review(id,rating,description,course_id)
values(503,'5','Awesome Course',103);
insert into Review(id,rating,description,course_id)
values(504,'3','So so Course',104);

insert into student_course(student_id,course_id)
values(201,101);
insert into student_course(student_id,course_id)
values(202,101);
insert into student_course(student_id,course_id)
values(203,101);
insert into student_course(student_id,course_id)
values(201,104);