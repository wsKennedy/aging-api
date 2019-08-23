--create table payments
create table financa.pagamento
(
	id_pagamento bigserial not null,
	protocolo bigint not null,
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