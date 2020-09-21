create database algafood;

DROP TABLE TAB_RESTAURANTE CASCADE;
CREATE TABLE TAB_RESTAURANTE (
    ID_RESTAURANTE SERIAL PRIMARY KEY,
    NM_RESTAURANTE VARCHAR(255) NOT NULL,
    TAXA_FRETE DECIMAL,
    ID_COZINHA BIGINT not null,
    CONSTRAINT FK_COZINHA FOREIGN KEY(ID_COZINHA) REFERENCES TAB_COZINHA(ID_COZINHA));

comment on table TAB_RESTAURANTE is 'Tabela que armazena as informações dos restaurantes';
comment on column TAB_RESTAURANTE.ID_RESTAURANTE is 'Identificador da tabela de restaurante';
comment on column TAB_RESTAURANTE.NM_RESTAURANTE is 'Nome do restaurante';
comment on column TAB_RESTAURANTE.TAXA_FRETE is 'taxa do frete que o restaurante possui';
comment on column TAB_RESTAURANTE.ID_COZINHA is 'Identificador do relacionamento com a tabela cozinha';

CREATE SEQUENCE SEQ_TAB_RESTAURANTE
    INCREMENT BY 1
    MAXVALUE 99999999;

DROP TABLE TAB_COZINHA CASCADE CONSTRAINTS;
CREATE TABLE TAB_COZINHA (
    ID_COZINHA SERIAL PRIMARY KEY,
    NM_COZINHA VARCHAR(255) NOT NULL);

comment on table TAB_COZINHA is 'Tabela que armazena as informações sobre a cozinha';
comment on column TAB_COZINHA.ID_COZINHA is 'Identificador da tabela cozinha';
comment on column TAB_COZINHA.NM_COZINHA is 'Nome da especialidade da cozinha';

CREATE SEQUENCE SEQ_TAB_COZINHA
    INCREMENT BY 1
    MAXVALUE 99999999;
