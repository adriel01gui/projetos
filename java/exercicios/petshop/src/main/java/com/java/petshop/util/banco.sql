insert into cliente values(null, "adriel@gmail.com", "Adriel", "21995544221");
insert into cliente values(null, "lucas@gmail.com", "Lucas", "219455462321");
insert into cliente values(null, "vania@gmail.com", "Vania", "216655442391");

insert into animal values(null, "Gato", "mia", "mesclado", 2);
insert into animal values(null, "Cachorro", "rex", "poodle", 1);
insert into animal values(null, "Cachorro", "tesla", "labrador", 3);


insert into produto values(null, "banho", 50);
insert into produto values(null, "ração", 20);
insert into produto values(null, "tosa", 40);
insert into produto values(null, "sache de gato", 8);


insert into venda values(null, now(),"Luidi", 1);
insert into venda values(null, now(),"Monica", 3);
insert into venda values(null, now(),"Monica", 2);

insert into itens_venda values(null, 1, 1, 1 ,2);
insert into itens_venda values(null, 1, 2, 2, 1);
insert into itens_venda values(null, 4, 3, 3, 3);

SELECT
  c.nome as nomeCliente,
  c.telefone,
  c.email,
  e.logradouro,
  e.bairro,
  a.nome as nomeAnimal,
  a.especie,
  a.raca,
  p.nome as nomeProduto,
  p.preco,
  iv.quantidade
FROM
  cliente c
INNER JOIN
  endereco e ON c.id = e.id_cliente
INNER JOIN
  animal a ON c.id = a.id_cliente
INNER JOIN
  itens_venda iv ON a.id = iv.id_cliente
INNER JOIN
  produto p ON iv.id_produto = p.id;