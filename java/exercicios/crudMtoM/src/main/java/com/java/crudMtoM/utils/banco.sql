insert into aluno values(null,"Adriel");
insert into aluno values(null,"Luis");
insert into aluno values(null,"Carol");
insert into aluno values(null,"Julia");

insert into disciplina values(null,"port");
insert into disciplina values(null,"mat");
insert into disciplina values(null,"geo");
insert into disciplina values(null,"hist");
insert into disciplina values(null,"quim");
insert into disciplina values(null,"fis");
insert into disciplina values(null,"lit");

insert into aluno_disciplina values(1,1);
insert into aluno_disciplina values(1,2);
insert into aluno_disciplina values(1,3);
insert into aluno_disciplina values(1,4);
insert into aluno_disciplina values(1,5);
insert into aluno_disciplina values(1,6);
insert into aluno_disciplina values(1,7);


insert into aluno_disciplina values(2,1);
insert into aluno_disciplina values(2,2);
insert into aluno_disciplina values(2,6);

insert into aluno_disciplina values(3,3);
insert into aluno_disciplina values(3,4);

insert into aluno_disciplina values(4,1);
insert into aluno_disciplina values(4,7);



select
    a.nome as nomeAluno, GROUP_CONCAT(d.nome) AS nomeDisciplinas
from aluno_disciplina ad
    left join aluno a on ad.aluno_id = a.id
    left join disciplina d on ad.disciplina_id = d.id
group by a.nome;
