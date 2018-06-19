CREATE DATABASE db_estudo_java;
use db_estudo_java;

CREATE TABLE db_estudo_java.tb_usuario(
 
	id_usuario INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DO USUÁRIO',
	ds_login   VARCHAR(30) NOT NULL COMMENT 'LOGIN DO USUÁRIO PARA ACESSO AO SISTEMA',
	ds_senha   VARCHAR(30) NOT NULL COMMENT 'SENHA DO USUÁRIO PARA ACESSO AO SISTEMA'   	
 
);

CREATE TABLE db_estudo_java.tb_pessoa(
 
    id_pessoa           INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DA PESSOA',
    nm_pessoa           VARCHAR(70)  NOT NULL COMMENT 'NOME DA PESSOA',
    fl_sexo	            CHAR(1)	     NOT NULL COMMENT 'INFORMAR M OU F',
    dt_cadastro         DATETIME     NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO',
    ds_email	        VARCHAR(80)  NOT NULL COMMENT 'EMAIL DA PESSOA',
    ds_endereco         VARCHAR(200) NOT NULL COMMENT 'DESCRIÇÃO DO ENDEREÇO',
    fl_origemCadastro   CHAR(1)	     NOT NULL COMMENT 'ORIGEM DO CADASTRO (I) = INPUT OU (X) = XML',	
    id_usuario_cadastro	INT	     NOT NULL COMMENT  'USUÁRIO LOGADO QUE CADASTROU A PESSOA'
 
);

CREATE TABLE db_estudo_java.tb_aluno(
 
    matricula           INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DA PESSOA',
    nome                VARCHAR(70)  NOT NULL COMMENT 'NOME DA PESSOA',
    sexo	            CHAR(1)	  NOT NULL COMMENT 'INFORMAR M OU F',
    dataNasc            DATE NOT NULL COMMENT 'DATA DE NASCIMENTO',
    idade				INT NOT NULL COMMENT 'IDADE DO ALUNO',
    nomePai				VARCHAR(70) NOT NULL COMMENT 'NOME DO PAI',
    nomeMae				VARCHAR(70) NOT NULL COMMENT 'NOME DA MÃe',
    telefone			VARCHAR(20) NOT NULL COMMENT 'TELEFONE PRA CONTATO',
    endereco         VARCHAR(200) NOT NULL COMMENT 'DESCRIÇÃO DO ENDEREÇO',
    dt_cadastro         DATETIME     NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO'
    
);

CREATE TABLE db_estudo_java.tb_turma(
	id					INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DA TURMA',
    nivel				VARCHAR(32) NOT NULL COMMENT 'NIVEL DA TURMA',
    nome				VARCHAR(32) NOT NULL COMMENT 'NOME DA TURMA',
    turno				VARCHAR(16) NOT NULL COMMENT 'TURNO',
    professor			INT NOT NULL COMMENT 'PROFESSOR RESPONSAVEL PELA TURMA'
    -- tem que criar a tabela professor
    -- foreign key(professor) professor db_estudo_java.tb_professor(id)
);

CREATE TABLE db_estudo_java.tb_professor(
 
    matricula           INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DA PESSOA',
    nome                VARCHAR(70)  NOT NULL COMMENT 'NOME DA PESSOA',
    dataNasc            DATE NOT NULL COMMENT 'DATA DE NASCIMENTO',
    telefone			VARCHAR(20) NOT NULL COMMENT 'TELEFONE PRA CONTATO',
    endereco         	VARCHAR(200) NOT NULL COMMENT 'DESCRIÇÃO DO ENDEREÇO',
    dt_cadastro         DATETIME     NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO'
);

ALTER TABLE db_estudo_java.tb_pessoa ADD FOREIGN KEY (id_usuario_cadastro) REFERENCES db_estudo_java.tb_usuario(id_usuario);

INSERT INTO db_estudo_java.tb_usuario (ds_login,ds_senha) VALUES('admin','123456');



-- Update db_estudo_java.tb_pessoa (nm_pessoa, fl_sexo, dt_cadastro, ds_email,
 -- ds_endereco, fl_origemCadastro, id_usuario_cadastro) values ();
 
 select * from tb_aluno;
UPDATE `db_estudo_java`.`tb_aluno` SET `nome`='Arthur gorgo' WHERE `matricula`='33';

 update tb_aluno set nome='Arthur Gorg' where matricula=33;