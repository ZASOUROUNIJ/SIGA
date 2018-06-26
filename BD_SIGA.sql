DROP DATABASE if exists db_estudo_java;
CREATE DATABASE db_estudo_java;
use db_estudo_java;

CREATE TABLE db_estudo_java.tb_usuario(
 
	id_usuario INT AUTO_INCREMENT COMMENT 'CÓDIGO DO USUÁRIO',
	ds_login   VARCHAR(30) NOT NULL COMMENT 'LOGIN DO USUÁRIO PARA ACESSO AO SISTEMA',
	ds_senha   VARCHAR(30) NOT NULL COMMENT 'SENHA DO USUÁRIO PARA ACESSO AO SISTEMA',
   	PRIMARY KEY (id_usuario)
 
);


CREATE TABLE db_estudo_java.tb_aluno(
 
    matricula INT AUTO_INCREMENT COMMENT 'CÓDIGO DA PESSOA',
    nome VARCHAR(70) NOT NULL COMMENT 'NOME DA PESSOA',
    sexo CHAR(1) NOT NULL COMMENT 'INFORMAR M OU F',
    dataNasc DATE NOT NULL COMMENT 'DATA DE NASCIMENTO',
    idade INT NOT NULL COMMENT 'IDADE DO ALUNO',
    nomePai VARCHAR(70) NOT NULL COMMENT 'NOME DO PAI',
    nomeMae VARCHAR(70) NOT NULL COMMENT 'NOME DA MÃe',
    telefone VARCHAR(20) NOT NULL COMMENT 'TELEFONE PRA CONTATO',
    endereco VARCHAR(200) NOT NULL COMMENT 'DESCRIÇÃO DO ENDEREÇO',
    dt_cadastro DATETIME NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO',
    PRIMARY KEY (matricula)
);

CREATE TABLE db_estudo_java.tb_professor(
 
    matricula INT AUTO_INCREMENT COMMENT 'CÓDIGO DA PESSOA',
    nome VARCHAR(70)  NOT NULL COMMENT 'NOME DA PESSOA',
    dataNasc DATE NOT NULL COMMENT 'DATA DE NASCIMENTO',
    telefone VARCHAR(20) NOT NULL COMMENT 'TELEFONE PRA CONTATO',
    endereco VARCHAR(200) NOT NULL COMMENT 'DESCRIÇÃO DO ENDEREÇO',
    dt_cadastro DATETIME NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO',
        PRIMARY KEY (matricula)
);

CREATE TABLE db_estudo_java.tb_turma(
	id INT AUTO_INCREMENT COMMENT 'CÓDIGO DA TURMA',
    nivel VARCHAR(32) NOT NULL COMMENT 'NIVEL DA TURMA',
    nome VARCHAR(32) NOT NULL COMMENT 'NOME DA TURMA',
    turno VARCHAR(16) NOT NULL COMMENT 'TURNO',
    professor INT COMMENT 'PROFESSOR RESPONSAVEL PELA TURMA',
    PRIMARY KEY (id),
    FOREIGN KEY (professor) REFERENCES db_estudo_java.tb_professor(matricula)
);

CREATE TABLE db_estudo_java.tb_turma_aluno(
	id INT COMMENT 'CÓDIGO DA TURMA',
	matricula INT NOT NULL COMMENT 'CÓDIGO DA PESSOA',
	ano INT NOT NULL,
	PRIMARY KEY (id, matricula),
	FOREIGN KEY (id) REFERENCES tb_turma(id),
	FOREIGN KEY (matricula) REFERENCES tb_aluno(matricula)   
);

INSERT INTO db_estudo_java.tb_usuario (ds_login,ds_senha) VALUES('admin','admin');
/*
INSERT INTO db_estudo_java.tb_aluno (nome,sexo,dataNasc,idade,nomePai,nomeMae,telefone,endereco,dt_cadastro) VALUES ('João','M','2010-06-06',8,'José Maria','Maria josé','996265878','rua francisca silva',current_timestamp());
INSERT INTO db_estudo_java.tb_professor(nome,dataNasc,telefone,endereco,dt_cadastro) VALUES('Gabriel Diniz','1990-01-01','999696969','Rua elizabeth Farias',current_timestamp());
update db_estudo_java.tb_professor set id_usuario_cadastro = 1;
INSERT INTO db_estudo_java.tb_turma(nivel,nome,turno,professor) VALUES ('1','A','M',1);
update db_estudo_java.tb_turma set id_usuario_cadastro = 1;
INSERT INTO db_estudo_java.tb_turma_aluno (id, matricula, ano) VALUES (1,1,2018);

*/