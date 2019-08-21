--create a database
-- create database agingdb;

--create new schemas
create schema config;
create schema financa;

--create table parameter
create table config.parametro
(
	id_parametro bigserial not null,
	nome varchar not null,
	valor varchar not null,
	descricao varchar
);

create unique index parametro_id_uindex
	on config.parametro (id_parametro);

alter table config.parametro
	add constraint parametro_pk
		primary key (id_parametro);


-- create table beneficiaries
create table financa.beneficiario
(
	id_beneficiario bigserial not null,
	protocolo bigint not null,
	nome varchar not null,
	saldo numeric(10,2)
);

create unique index beneficiario_id_beneficiario_uindex
	on financa.beneficiario (id_beneficiario);

alter table financa.beneficiario
	add constraint beneficiario_pk
		primary key (id_beneficiario);




--create table payments
create table financa.pagamento
(
	id_pagamento bigserial not null,
	valor numeric(10,2) not null,
	data_pagamento date not null,
	id_beneficiario bigint not null
		constraint pagamento_beneficiario_id_beneficiario_fk
			references financa.beneficiario
);

create unique index pagamento_id_pagamento_uindex
	on financa.pagamento (id_pagamento);

alter table financa.pagamento
	add constraint pagamento_pk
		primary key (id_pagamento);




-- create table withdraw
create table financa.saque
(
	id_saque bigserial not null,
	valor numeric(10,2) not null,
	data_saque date not null,
	descricao varchar,
	id_beneficiario bigint not null
		constraint saque_beneficiario_id_beneficiario_fk
			references financa.beneficiario
);

create unique index saque_id_saque_uindex
	on financa.saque (id_saque);

alter table financa.saque
	add constraint saque_pk
		primary key (id_saque);



