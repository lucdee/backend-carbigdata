CREATE TABLE cliente (
    cod_cliente BIGSERIAL PRIMARY KEY,
    nme_cliente VARCHAR(120) NOT NULL,
    dta_nascimento DATE NOT NULL,
    nro_cpf VARCHAR(14) NOT NULL UNIQUE,
    dta_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE endereco (
    cod_endereco BIGSERIAL PRIMARY KEY,
    nme_logradouro VARCHAR(150) NOT NULL,
    nme_bairro VARCHAR(120) NOT NULL,
    nro_cep VARCHAR(10) NOT NULL,
    nme_cidade VARCHAR(80) NOT NULL,
    nme_estado VARCHAR(2) NOT NULL
);

CREATE TABLE ocorrencia (
    cod_ocorrencia BIGSERIAL PRIMARY KEY,
    cod_cliente BIGINT NOT NULL REFERENCES cliente(cod_cliente),
    cod_endereco BIGINT NOT NULL REFERENCES endereco(cod_endereco),
    dta_ocorrencia TIMESTAMP NOT NULL,
    sta_ocorrencia VARCHAR(20) NOT NULL CHECK (sta_ocorrencia IN ('ATIVA','FINALIZADA'))
);

CREATE TABLE foto_ocorrencia (
    cod_foto_ocorrencia BIGSERIAL PRIMARY KEY,
    cod_ocorrencia BIGINT NOT NULL REFERENCES ocorrencia(cod_ocorrencia),
    dta_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dsc_path_bucket VARCHAR(255) NOT NULL,
    dsc_hash VARCHAR(255) NOT NULL
);

CREATE TABLE app_user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(80) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(80) NOT NULL
);
