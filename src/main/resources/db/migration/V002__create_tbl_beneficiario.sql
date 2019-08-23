create schema financa;

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