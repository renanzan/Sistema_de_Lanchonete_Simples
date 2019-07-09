CREATE SCHEMA `superburguer`;
DROP SCHEMA `superburguer`;
USE superburguer;



-- Cria a tabela Usuários
CREATE TABLE USUARIOS
(
    p_nome				VARCHAR(15)						NOT NULL,
    s_nome 				VARCHAR(15)    				    NOT NULL,
    username 				VARCHAR(15) 	  			  	NOT NULL,
    senha 				VARCHAR(20) 					NOT NULL,
    tipo_usuario        ENUM('CAIXA', 'GERENTE')        NOT NULL,
    
    PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE USUARIOS; -- Deleta a tabela de Usuários



-- Cria tabela Produtos
CREATE TABLE PRODUTOS
(
    cod_produto				INT										NOT NULL AUTO_INCREMENT,
    nome 					VARCHAR(150) 							NOT NULL,
    descricao 				VARCHAR(255) 							NOT NULL,
    tipo					ENUM('LANCHE', 'BEBIDA', 'DOCE')		NOT NULL,
    preco					DOUBLE(5,2) 							NOT NULL,
    imagem					LONGBLOB								NULL,
    
    PRIMARY KEY (cod_produto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE PRODUTOS; -- Deleta a tabela de Produtos




-- Cria a tabela Pedidos
CREATE TABLE PEDIDOS
(
    num_pedido			VARCHAR(50) 					NOT NULL,
    status_pedido		ENUM('PAGO', 'PENDENTE')		NOT NULL,
    data_hora			TIMESTAMP						NOT NULL,
    
    PRIMARY KEY (num_pedido)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE PEDIDOS; -- Deleta a tabela de Pedidos







-- Cria a tabela Itens_de_pedido
CREATE TABLE ITENS_DE_PEDIDO
(
    id_item_pedido				INT				NOT NULL AUTO_INCREMENT,
    num_pedido 					VARCHAR(50)		NOT NULL,
    cod_produto 				INT 			NOT NULL,
    
    PRIMARY KEY (id_item_pedido),
    FOREIGN KEY (num_pedido) references pedidos(num_pedido) ON DELETE CASCADE,
    FOREIGN KEY (cod_produto) references produtos(cod_produto) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE ITENS_DE_PEDIDO; -- Deleta a tabela de Itens do pedido