CREATE TABLE PERSON (
	id bigserial not null,
	group_person_id bigint not null,
	name varchar(255) not null,
	gender varchar(255) not null,
	birthdate date,
	rank int not null,
	CONSTRAINT person_pkey PRIMARY KEY (id),
	CONSTRAINT person_group_person_fkey FOREIGN KEY (group_person_id) REFERENCES GROUP_PERSON(ID)
);

insert into PERSON (name, group_person_id, gender, birthdate, rank) values ('hvle', 1, 'male', '1985-01-18', 130);
insert into PERSON (name, group_person_id, gender, birthdate, rank) values ('mbon', 1, 'male', null, 130);
insert into PERSON (name, group_person_id, gender, birthdate, rank) values ('stas', 2, 'female', null, 120);
insert into PERSON (name, group_person_id, gender, birthdate, rank) values ('cmes', 2, 'male', null, 120);
insert into PERSON (name, group_person_id, gender, birthdate, rank) values ('jsai', 2, 'male', null, 115);
insert into PERSON (name, group_person_id, gender, birthdate, rank) values ('bmed', 2, 'female', null, 100);

commit;