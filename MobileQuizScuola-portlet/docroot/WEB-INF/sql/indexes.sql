create index IX_5C318AA6 on quiz_Argomento (idMateria);
create index IX_5D1EAEE0 on quiz_Argomento (uuid_);
create index IX_3B734948 on quiz_Argomento (uuid_, companyId);
create unique index IX_D24D81CA on quiz_Argomento (uuid_, groupId);

create index IX_A7F335D7 on quiz_Classe (uuid_);
create index IX_D1591F1 on quiz_Classe (uuid_, companyId);
create unique index IX_9A0BE0B3 on quiz_Classe (uuid_, groupId);

create index IX_B7C4FC5 on quiz_Domanda (idArgomento);
create index IX_1DC183AD on quiz_Domanda (idArgomento, posizione);
create index IX_95F51FCC on quiz_Domanda (uuid_);
create index IX_10FB4CDC on quiz_Domanda (uuid_, companyId);
create unique index IX_7F695A5E on quiz_Domanda (uuid_, groupId);

create index IX_B671677D on quiz_Materia (idClasse);
create index IX_8870CDB3 on quiz_Materia (uuid_);
create index IX_51ADB895 on quiz_Materia (uuid_, companyId);
create unique index IX_37056057 on quiz_Materia (uuid_, groupId);

create index IX_8820D6C on quiz_Risposta (idDomanda);
create index IX_120AB8EE on quiz_Risposta (idDomanda, esatta);
create index IX_4921811F on quiz_Risposta (uuid_);
create index IX_B890E9A9 on quiz_Risposta (uuid_, companyId);
create unique index IX_A569C66B on quiz_Risposta (uuid_, groupId);

create index IX_E45DFD33 on quiz_RispostaUtente (idDomanda);
create index IX_3B78CAF6 on quiz_RispostaUtente (idUtente);
create index IX_139E42CB on quiz_RispostaUtente (idUtente, idDomanda);
create index IX_61826C66 on quiz_RispostaUtente (uuid_);