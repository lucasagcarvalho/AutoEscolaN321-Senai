CREATE TABLE ALUNOS
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    ativo       TINYINT(1)   DEFAULT 1,
    nome        VARCHAR(100) NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE,
    telefone    VARCHAR(15)  NOT NULL,
    cpf         VARCHAR(11)  NOT NULL UNIQUE,
    logradouro  VARCHAR(100) NOT NULL,
    numero      VARCHAR(20),
    complemento VARCHAR(100),
    bairro      VARCHAR(100) NOT NULL,
    cidade      VARCHAR(100) NOT NULL,
    uf          VARCHAR(2)   NOT NULL,
    cep         VARCHAR(9)   NOT NULL,

    PRIMARY KEY (id)
);