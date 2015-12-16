CREATE TABLE PERSON (
	id bigint auto_increment primary key,
	name varchar(255) not null,
	gender varchar(255) not null,
	birthdate date,
	rank int not null
);