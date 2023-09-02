insert into produto values(null,"eletronicos","ps5",2000,4000);
insert into produto values(null,"eletronicos","galaxyS23",2400, 5000);
insert into produto values(null,"eletronicos","iphone14",2800 ,6000);
insert into produto values(null,"saude","tylenol", 0.5, 6);

insert into venda values(null,"Jorge","Ana");
insert into venda values(null,"Carlos","Joao");
insert into venda values(null,"Luiza","Lucas");
insert into venda values(null,"Rose","Lais");

insert into itens_venda values(null, 3 ,2, 1);
insert into itens_venda values(null, 2 ,1, 2);
insert into itens_venda values(null, 1 ,3, 3);
insert into itens_venda values(null, 4 ,4, 4);


select
    p.nome_produto as nomeDoProduto, p.categoria, p.preco_compra, p.preco_venda,
    v.quem_vendeu, v.nome_cliente, i.quantidade
from itens_venda i
        left join produto p on i.produto_id = p.id
        left join venda v on i.vendas_id = v.id
order by v.nome_cliente asc;