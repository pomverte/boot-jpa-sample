CREATE TABLE GROUP_PERSON (
	id bigserial not null,
	name varchar(255) not null,
	CONSTRAINT group_person_pkey PRIMARY KEY (id),
	UNIQUE (name)
);

insert into GROUP_PERSON (name) values ('ATP');
insert into GROUP_PERSON (name) values ('BOOST');
