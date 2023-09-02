package com.java.crudMtoM.controllers;

import com.java.crudMtoM.model.dto.DisciplinaDTO;
import com.java.crudMtoM.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping("/salvar")
    public void salvar(@RequestBody DisciplinaDTO disciplinaDTO) {
        try {
            disciplinaService.salvar(disciplinaDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
