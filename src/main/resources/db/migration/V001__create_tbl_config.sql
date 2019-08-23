--create new schemas
create schema config;

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