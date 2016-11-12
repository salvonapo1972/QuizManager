create index IX_16EB86C0 on Quiz_Argomento (uuid_);
create index IX_977AC568 on Quiz_Argomento (uuid_, companyId);
create unique index IX_CC4585EA on Quiz_Argomento (uuid_, groupId);

create index IX_B3B869F7 on Quiz_Classe (uuid_);
create index IX_6FFC89D1 on Quiz_Classe (uuid_, companyId);
create unique index IX_700F5093 on Quiz_Classe (uuid_, groupId);

create index IX_2D66FAC on Quiz_Domanda (uuid_);
create index IX_AF350FC on Quiz_Domanda (uuid_, companyId);
create unique index IX_69D3E67E on Quiz_Domanda (uuid_, groupId);

create index IX_F5521D93 on Quiz_Materia (uuid_);
create index IX_4BA5BCB5 on Quiz_Materia (uuid_, companyId);
create unique index IX_216FEC77 on Quiz_Materia (uuid_, groupId);

create index IX_786A2D3F on Quiz_Risposta (uuid_);
create index IX_FD996989 on Quiz_Risposta (uuid_, companyId);
create unique index IX_850BE4B on Quiz_Risposta (uuid_, groupId);

create index IX_47618086 on Quiz_RispostaUtente (uuid_);