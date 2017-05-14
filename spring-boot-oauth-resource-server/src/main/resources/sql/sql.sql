use test;
drop table if exists user_pic;
drop table if exists course_enrollment;
drop table if exists course;
drop table if exists tutor;
drop table if exists student;
drop table if exists addresse;


create table addresse 
(
  addr_id int(11) not null auto_increment,
  street varchar(50) not null,
  city varchar(50) not null,
  state varchar(50) not null,
  zip varchar(10) default null,
  country varchar(50) not null,
  primary key (addr_id)
) engine=innodb auto_increment=1 default charset=utf8;

create table student 
(
  stud_id int(11) not null auto_increment,
  name varchar(50) not null,
  email varchar(50) not null,
  phone varchar(15) default null,  
  dob date default null,
  bio longtext default null,
  pic blob default null,
  addr_id int(11) default null,  
  primary key (stud_id),
  constraint fk_student_addr foreign key (addr_id) references addresse (addr_id)
) engine=innodb auto_increment=1 default charset=utf8;

create table tutor 
(
  tutor_id int(11) not null auto_increment,
  name varchar(50) not null,
  email varchar(50) not null,
  phone varchar(15) default null,  
  dob date default null,
  bio longtext default null,
  pic blob default null,
  addr_id int(11) default null,
  primary key (tutor_id),
  constraint fk_tutor_addr foreign key (addr_id) references addresse (addr_id)  
) engine=innodb auto_increment=1 default charset=utf8;


create table course 
(
  course_id int(11) not null auto_increment,
  name varchar(100) not null,
  description varchar(512) default null,
  start_date date default null,
  end_date date default null,
  tutor_id int(11) not null,
  primary key (course_id),
  constraint fk_course_tutor foreign key (tutor_id) references tutor (tutor_id)
) engine=innodb auto_increment=1 default charset=utf8;


create table course_enrollment
(
  course_id int(11) not null,
  stud_id int(11) not null,
  primary key (course_id,stud_id),
  constraint fk_enrollment_stud foreign key (stud_id) references student (stud_id),
  constraint fk_enrollment_course foreign key (course_id) references course (course_id)
) engine=innodb default charset=utf8;



create table user_pic 
(
  id int(11) not null auto_increment,
  name varchar(50) default null,
  pic blob,
  bio longtext,
  primary key (id)
) engine=innodb auto_increment=1 default charset=utf8;






insert into addresse (addr_id,street,city,state,zip,country) values 
 (1,'4891 pacific hwy','san diego','ca','92110','san diego'),
 (2,'2400 n jefferson st','perry','fl','32347','taylor'),
 (3,'710 n cable rd','lima','oh','45825','allen'),
 (4,'5108 w gore blvd','lawton','ok','32365','comanche');


insert into student (stud_id,name,email,phone,dob,bio,pic,addr_id) values 
 (1,'timothy','timothy@gmail.com','123-123-1234','1988-04-25',null,null,3),
 (2,'douglas','douglas@gmail.com','789-456-1234','1990-08-15',null,null,4);


insert into tutor (tutor_id,name,email,phone,dob,bio,pic,addr_id) values 
 (1,'john','john@gmail.com','111-222-3333','1980-05-20',null,null,1),
 (2,'paul','paul@gmail.com','123-321-4444','1981-03-15',null,null,2);


insert into course (course_id,name,description,start_date,end_date,tutor_id) values 
 (1,'quickstart core java','core java programming','2013-03-01','2013-04-15',1),
 (2,'quickstart javaee6','enterprise app development using javaee6','2013-04-01','2013-08-30',1),
 (3,'mybatis3 premier','mybatis 3 framework','2013-06-01','2013-07-15',2);


insert into course_enrollment (course_id,stud_id) values 
 (1,1),
 (1,2),
 (2,2);



use test;
drop table if exists atl_bank;
drop table if exists company;

create table atl_bank (
  id bigint(20) not null auto_increment,
  bank_name varchar(32) default null,
  bank_code varchar(32) default null,
  country_code varchar(10) default null,
  bank_type varchar(32) default null,
  created_date timestamp null default current_timestamp,
  primary key (id)
) engine=innodb  default charset=utf8;

create table company (
  id bigint(20) not null auto_increment,
  company_oid varchar(36) not null,
  name varchar(255) not null,
  logo_id bigint(20) default null,
  created_by varchar(36) default 'system',
  created_date timestamp null default current_timestamp,
  done_register_lead bit(1) default b'1',
  tax_id varchar(100) default null,
  primary key (id),
  unique key name (name),
  unique key company_oid (company_oid),
  unique key logo_id (logo_id)
) engine=innodb  default charset=utf8;



CREATE TABLE city (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	state varchar(100) NOT NULL,
	create_time TIMESTAMP NULL,
	create_by varchar(100) NULL,
	lastmodified_time TIMESTAMP NULL,
	lastmodified_by varchar(100) NULL,
	CONSTRAINT city_UN UNIQUE KEY (name),
	CONSTRAINT city_PK PRIMARY KEY (id)
)engine=innodb  default charset=utf8;
