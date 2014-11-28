create table "mvc".division
(
	code integer,
	libelle character varying(50),
	constraint pk_division primary key (code)
);

create table "mvc".eleve
(
	code integer,
	nom character varying(50),
	prenom character varying(50),
	date character varying(10),
	division integer,
	constraint pk_eleve primary key (code),
	constraint fk_eleve_division foreign key (division) references "mvc".division (code)
);

insert into "mvc".eleve values
(0, 'THIERRY', 'Florian', '1234-01-01', 0);
