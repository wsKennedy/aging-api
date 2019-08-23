-- create table withdraw
create table financa.saque
(
	id_saque bigserial not null,
	protocolo bigint not null,
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