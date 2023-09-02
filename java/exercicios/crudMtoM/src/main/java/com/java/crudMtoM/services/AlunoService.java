package com.java.crudMtoM.services;

import com.java.crudMtoM.model.Aluno;
import com.java.crudMtoM.model.Disciplina;
import com.java.crudMtoM.model.dto.AlunoDTO;
import com.java.crudMtoM.model.dto.DisciplinaDTO;
import com.java.crudMtoM.repositories.AlunoRepository;
import com.java.crudMtoM.repositories.DisciplinaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    ModelMapper modelMapper = new ModelMapper();


    public void salvar(AlunoDTO alunoDTO) throws Exception {
        Aluno aluno = modelMapper.map(alunoDTO, Aluno.class);
        alunoRepository.save(aluno);
    }

    public void excluir(Long id) throws Exception {
        Aluno aluno = alunoRepository.findById(id).get();
        if (aluno != null) {
            alunoRepository.delete(aluno);
        }
    }

    @Transactional
    public void associarAlunoComDisciplina(long idAluno, long idDisciplina) {
        Aluno aluno = alunoRepository.findById(idAluno).orElse(null);
        Disciplina disciplina = disciplinaRepository.findById(idDisciplina).orElse(null);

        if (aluno != null && disciplina != null) {
            aluno.getDisciplinas().add(disciplina);
            disciplina.getAlunos().add(aluno);
            alunoRepository.save(aluno);
            disciplinaRepository.save(disciplina);
        } else {
            throw new RuntimeException("Aluno ou Disciplina não encontrados.");
        }
    }

    @Transactional
    public void excluirDisciplinaDoAluno(Long alunoId, Long disciplinaId) throws Exception {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new Exception("Aluno não encontrado com o ID: " + alunoId));

        Disciplina disciplina = disciplinaRepository.findById(disciplinaId)
                .orElseThrow(() -> new Exception("Disciplina não encontrada com o ID: " + disciplinaId));

        aluno.getDisciplinas().remove(disciplina);
        alunoRepository.save(aluno);
    }


    public List<AlunoDTO> listarAlunosComDisciplinas() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AlunoDTO convertToDTO(Aluno aluno) {
        AlunoDTO alunoDTO = modelMapper.map(aluno, AlunoDTO.class);
        List<DisciplinaDTO> disciplinasDTO = aluno.getDisciplinas().stream()
                .map(this::convertDisciplinaToDTO)
                .collect(Collectors.toList());
        alunoDTO.setDisciplinasDTO(disciplinasDTO);
        return alunoDTO;
    }

    private DisciplinaDTO convertDisciplinaToDTO(Disciplina disciplina) {
        return modelMapper.map(disciplina, DisciplinaDTO.class);
    }

}