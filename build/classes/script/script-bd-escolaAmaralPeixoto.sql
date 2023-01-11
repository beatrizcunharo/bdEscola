---------------------------------> TABELA PESSOA

create table pessoa(
	cod_pessoa int primary key generated always as identity,
  	cpf_pessoa varchar(14) not null,
	nome_pessoa varchar(40) not null,
	data_nasc_pessoa date not null,
  	email_pessoa varchar(50),
  	telefone_pessoa varchar(14) not null,
	obs_pessoa varchar(300)
);

alter table pessoa add constraint un_cpf unique (cpf_pessoa);

---------------------------------> TABELA TURMA

create table turma (
	cod_turma int primary key generated always as identity,
	nome_turma varchar(20) not null,
	obs_turma varchar(200),
	turno_turma varchar(30) not null
);

---------------------------------> TABELA ALUNO

create table aluno(
	cod_aluno int,
	cod_turma int not null,
  	matricula_aluno varchar(10) not null,
	nome_resp_aluno varchar(30) not null,
	telefone_resp_aluno varchar(14) not null,
	email_resp_aluno varchar(50)
);

alter table aluno add constraint fk_cod_aluno foreign key (cod_aluno) 
	references pessoa(cod_pessoa) match simple
    on update cascade
    on delete no action;
    
alter table aluno add constraint fk_cod_turma foreign key (cod_turma) 
	references turma(cod_turma) match simple
    on update cascade
    on delete no action;
    
alter table aluno add primary key (cod_aluno);

alter table aluno add constraint un_matricula_aluno unique(matricula_aluno);

---------------------------------> TABELA DISCIPLINA

create table disciplina (
	cod_disciplina int primary key generated always as identity,
	nome_disciplina varchar(20) not null,
    obs_disciplina varchar(300)
);

---------------------------------> TABELA PROFESSOR

create table professor(
	cod_professor int,
	cod_disciplina int not null, 
	matricula_professor varchar(10) not null,
	data_contrato_professor date not null
);

alter table professor add constraint un_prof_matricula unique (matricula_professor);

alter table professor add constraint fk_cod_professor foreign key (cod_professor) 
	references pessoa(cod_pessoa) match simple
    on update cascade
    on delete no action;
    
alter table professor add constraint fk_cod_disciplina foreign key (cod_disciplina) 
	references Disciplina(cod_disciplina) match simple
    on update cascade
    on delete no action;
    
alter table professor add primary key (cod_professor);

---------------------------------> TABELA LOGIN

create table login(
	cod_login int primary key generated always as identity,
	cod_pessoa int not null,
	usuario_login varchar(15) not null,
  	senha_login varchar(200) not null
);

alter table login add constraint un_cod_pessoa unique (cod_pessoa);

alter table login add constraint fk_cod_pessoa foreign key (cod_pessoa) 
	references pessoa(cod_pessoa) match simple
    on update cascade
    on delete no action;
	
---------------------------------> TABELA EVENTOS

create table eventos(
	cod_evento int primary key generated always as identity,
  	nome_evento varchar(100) not null,
  	data_evento date not null,
	descricao_evento varchar(500)
);

---------------------------------> TABELA BIBLIOTECA

create table biblioteca(
	cod_livro int primary key generated always as identity,
  	nome_livro varchar(50) not null,
	descr_livro varchar not null,
  	autor_livro varchar(30) not null,
	ano_livro varchar(30) not null,
	grupo_espec_livro varchar(300) not null,
	genero_livro varchar(50) not null,
	qtde_livro int not null
);

---------------------------------> TABELA EMPRESTIMO LIVROS

create table emprestimoLivros(
	cod_livro int,
	cod_pessoa int,
  	data_emprestimo date not null,
	data_devolucao date,
	status_emprestimo varchar(15) not null,
	qtde_emprestimo int not null
);

alter table emprestimoLivros add constraint fk_cod_livro foreign key (cod_livro) 
	references biblioteca(cod_livro) match simple
    on update cascade
    on delete no action;
    
alter table emprestimoLivros add constraint fk_cod_pessoa foreign key (cod_pessoa) 
	references pessoa(cod_pessoa) match simple
    on update cascade
    on delete no action;
    
alter table emprestimoLivros add primary key (cod_livro, cod_pessoa);

---------------------------------> TABELA AULAS

create table aulas (
	cod_aula int primary key generated always as identity,
	hora_aula date not null,
  	dia_semana varchar(15),
	cod_professor int not null,
	descr_aula varchar(300)
);

alter table aulas add constraint fk_cod_professor foreign key (cod_professor) 
	references professor(cod_professor) match simple
    on update cascade
    on delete set null;
	
alter table aulas add constraint un_aulas unique (hora_aula, dia_semana, cod_professor);
alter table aulas alter column hora_aula type time without time zone using hora_aula::timestamp without time zone;

---------------------------------> TABELA ALUNO AULA

create table alunoaula(
	cod_aluno int,
	cod_aula int,
	obs_aula varchar(200)
);

alter table alunoaula add constraint fk_cod_aula foreign key (cod_aula) 
	references aulas(cod_aula) match simple
    on update cascade
    on delete cascade;
    
alter table alunoaula add constraint fk_cod_aluno foreign key (cod_aluno) 
	references aluno(cod_aluno) match simple
    on update cascade
    on delete no action;
    
alter table alunoaula add primary key (cod_aluno, cod_aula);

---------------------------------> TABELA RECURSOS

create table recursos(
	cod_recurso int primary key generated always as identity,
  	nome_recurso varchar(20) not null,
  	descr_recurso varchar(200),
	qtde_recurso int not null
);

---------------------------------> TABELA RECURSOS AULA

create table recursosaula(
  	cod_recurso int,
	cod_aula int,
	data_uso date not null,
	data_devolucao date
);

alter table recursosaula add constraint fk_cod_recurso foreign key (cod_recurso) 
	references recursos(cod_recurso) match simple
    on update cascade
    on delete cascade;
    
alter table recursosaula add constraint fk_cod_aula foreign key (cod_aula) 
	references aulas(cod_aula) match simple
    on update cascade
    on delete cascade;
    
alter table recursosaula add primary key (cod_recurso, cod_aula);

---------------------------------> TABELA ALUNO DISCIPLINA

create table alunodisciplina (
	cod_disciplina int,
	cod_aluno int,
	nota_disciplina float,
	freq_disciplina float,
  	bimestre int,
  	ano int,
  	aprovacao varchar
);

alter table alunodisciplina add constraint fk_cod_disciplina foreign key (cod_disciplina) 
	references disciplina (cod_disciplina) match simple
    on update cascade
    on delete no action;
    
alter table alunodisciplina add constraint fk_cod_aluno foreign key (cod_aluno) 
	references aluno (cod_aluno) match simple
    on update cascade
    on delete no action;
    
alter table alunodisciplina add constraint pk_disciplina primary key(cod_disciplina, cod_aluno, bimestre, ano);

---------------------------------> TABELA PROFESSOR TURMA

create table professorturma (
	cod_professor int,
	cod_turma int,
	data_turma varchar(20),
	material_turma varchar(200),
	obs_turma varchar(200)
);

alter table professorturma add constraint fk_cod_professor foreign key (cod_professor) 
	references professor(cod_professor) match simple
    on update cascade
    on delete set null;
    
alter table professorturma add constraint fk_cod_turma foreign key (cod_turma) 
	references turma (cod_turma) match simple
    on update cascade
    on delete cascade;
    
alter table professorturma add primary key (cod_turma, cod_professor);