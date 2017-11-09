drop database if exists projetocemiterio;
create database projetocemiterio;

use projetocemiterio;

create table falecido(
	numero_processo_obito int(45) primary key not null,
    obito_data datetime,
    nome_falecido varchar(45),
    nome_pai varchar(45),
    nome_mae varchar(45),
    idade int(3),
    sexo varchar(45),
    raca_cor varchar(45),
    estado_civil varchar(45),
    causa_morte varchar(45),
    medico_nome varchar(45),
    medico_crm int(45)
);

create table requerente(
	nome varchar(45),
    endereco varchar(45),
    telefone varchar(45),
    rg varchar(45),
    cpf varchar(45) primary key not null
);

create table sepultamento(
	numero_processo_obito int(45),
    orgao_emissor varchar(45),
    obito_data datetime,
    nome_falecido varchar(45),
    nome_pai varchar(45),
    nome_mae varchar(45),
    idade int(3),
    sexo varchar(45),
    raca_cor varchar(45),
    estado_civil varchar(45),
    causa_morte varchar(45),
    medico_nome varchar(45),
    medico_crm int(45),
    nome_requerente varchar(45),
    endereco varchar(45),
    telefone1 varchar(45),
    telefone2 varchar(45),
    rg varchar(45),
    cpf varchar(45) primary key not null
);