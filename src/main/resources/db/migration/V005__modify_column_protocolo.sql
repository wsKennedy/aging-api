--modify all column protocolo

alter table financa.beneficiario alter column protocolo type varchar using protocolo::varchar;
alter table financa.pagamento alter column protocolo type varchar using protocolo::varchar;
alter table financa.saque alter column protocolo type varchar using protocolo::varchar;
