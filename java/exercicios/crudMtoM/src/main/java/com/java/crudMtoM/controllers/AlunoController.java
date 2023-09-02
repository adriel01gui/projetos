package com.java.crudMtoM.controllers;

import com.java.crudMtoM.model.dto.AlunoDTO;
import com.java.crudMtoM.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @PostMapping("/salvar")
    public void salvar(@RequestBody AlunoDTO alunoDTO) {
        try {
            alunoService.salvar(alunoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        try {
            alunoService.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/listar")
    public List<AlunoDTO> listarAlunosEDisciplinas() {
        return alunoService.listarAlunosComDisciplinas();
    }


    @PostMapping("/associarAD")
    public ResponseEntity<String> associarAlunoDisciplina(@RequestParam("alunoId") Long alunoId,
                                                          @RequestParam("disciplinaId") Long disciplinaId) {
        try {
            alunoService.associarAlunoComDisciplina(alunoId, disciplinaId);
            return ResponseEntity.ok("Associação realizada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao associar aluno com disciplina: " + e.getMessage());
        }
    }

    @DeleteMapping("/{alunoId}/disciplina/{disciplinaId}")
    public ResponseEntity<String> excluirDisciplinaDoAluno(@PathVariable Long alunoId, @PathVariable Long disciplinaId) {
        try {
            alunoService.excluirDisciplinaDoAluno(alunoId, disciplinaId);
            return ResponseEntity.ok("Disciplina excluída do aluno com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir a disciplina do aluno: " + e.getMessage());
        }
    }

}