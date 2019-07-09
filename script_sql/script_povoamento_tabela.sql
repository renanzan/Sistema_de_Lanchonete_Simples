use superburguer;

-- Insere tuplas em Usuários
INSERT INTO USUARIOS
VALUES
('Raphael', 'Rodrigues', 'raphael',	'123456', 'Gerente'),
('Lucas', 'Horta', 'lucas',	'123456', 'Caixa'),
('Matheus', 'Lucas', 'matheus',	'123456', 'Gerente'),
('Diogo', 'Jorge', 'diogo',	'123456', 'Caixa'),
('Renan', 'Zanoti', 'renan', '123456', 'Gerente');



-- Insere tuplas em Produtos
INSERT INTO PRODUTOS
VALUES
(1,'Hambúrguer', 'Pão, Alface, Tomate, Batata palha e Carne de boi 150gr', 'LANCHE', '8.00', NULL),
(2,'X-Burguer', 'Pão, Alface, Tomate, Batata palha, Queijo e Carne de boi 150gr', 'LANCHE', '10.00', NULL),
(3,'X-Bacon Burguer', 'Pão, Alface, Tomate, Batata palha, Queijo, Bacon e Carne de boi 150gr', 'LANCHE', '12.00', NULL),
(4, 'X-Egg Bacon Burguer', 'Pão, Alface, Tomate, Batata palha, Queijo, Ovo, Bacon e Carne de boi 150gr', 'LANCHE', '14.00', NULL),
(5, 'X-Tudo', 'Pão, Alface, Tomate, Batata palha, Queijo, Presunto, Ovo, Bacon, Carne de boi 200gr', 'LANCHE', '16.00', NULL),
(6,'Super Burguer', 'Pão, Alface, Tomate, Batata palha, Queijo, Presunto, Ovo, Bacon, Frango desfiado, Carne de boi 250gr', 'LANCHE', '20.00', NULL),
(7,'Coca Cola', 'Lata 350ml', 'BEBIDA', '4.00', NULL),
(8,'Coca Cola', 'Garrafa 1L', 'BEBIDA', '6.00', NULL),
(9,'Coca Cola', 'Garrafa 2L', 'BEBIDA', '8.00', NULL),
(10,'Guaraná', 'Lata 350ml', 'BEBIDA', '4.00', NULL),
(11,'Guaraná', 'Garrafa 1L', 'BEBIDA', '6.00', NULL),
(12,'Guaraná', 'Garrafa 2L', 'BEBIDA', '8.00', NULL),
(13,'Laka', 'Barra 20gr', 'DOCE', '3.00', NULL),
(14,'Diamante Negro', 'Barra 20gr', 'DOCE', '3.00', NULL);



-- Insere tuplas em PEDIDOS
INSERT INTO PEDIDOS
VALUES
('1',	'PAGO', NOW()),
('2',	'PAGO', NOW()),
('3',	'PAGO', NOW()),
('4',	'PAGO', NOW()),
('5',	'PAGO', NOW());






-- Insere tuplas em Itens_de_pedido
INSERT INTO ITENS_DE_PEDIDO
VALUES
(null, 1, 3),
(null, 1, 7),
(null, 2, 2),
(null, 2, 8),
(null, 3, 5),
(null, 3, 9),
(null, 3, 13),
(null, 4, 4),
(null, 4, 10),
(null, 5, 1),
(null, 5, 6);


