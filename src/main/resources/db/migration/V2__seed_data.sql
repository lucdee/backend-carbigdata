INSERT INTO cliente(nme_cliente, dta_nascimento, nro_cpf) VALUES
('Maria Souza', '1990-03-15', '111.222.333-44'),
('João Silva', '1985-09-20', '555.666.777-88');

INSERT INTO endereco(nme_logradouro, nme_bairro, nro_cep, nme_cidade, nme_estado) VALUES
('Rua A, 100', 'Centro', '01000-000', 'São Paulo', 'SP'),
('Av. Brasil, 200', 'Jardins', '20000-000', 'Rio de Janeiro', 'RJ');

INSERT INTO ocorrencia(cod_cliente, cod_endereco, dta_ocorrencia, sta_ocorrencia) VALUES
(1, 1, CURRENT_TIMESTAMP, 'ATIVA'),
(2, 2, CURRENT_TIMESTAMP - INTERVAL '2 day', 'FINALIZADA');
