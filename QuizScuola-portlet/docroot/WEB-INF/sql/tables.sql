create table Quiz_Argomento (
	uuid_ VARCHAR(75) null,
	idArgomento LONG not null primary key,
	descArgomento VARCHAR(75) null,
	idMateria LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Quiz_Classe (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	descClasse VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Quiz_Domanda (
	uuid_ VARCHAR(75) null,
	idDomanda LONG not null primary key,
	descDomanda VARCHAR(75) null,
	idArgomento LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Quiz_Materia (
	uuid_ VARCHAR(75) null,
	idMateria LONG not null primary key,
	descMateria VARCHAR(75) null,
	idClasse LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Quiz_Risposta (
	uuid_ VARCHAR(75) null,
	idRisposta LONG not null primary key,
	descRisposta VARCHAR(75) null,
	posizione INTEGER,
	esatta BOOLEAN,
	idDomanda LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Quiz_RispostaUtente (
	uuid_ VARCHAR(75) null,
	idRispostaUtente LONG not null primary key,
	idRisposta LONG,
	idUtente LONG,
	dataRisposta DATE null,
	idDomanda LONG
);