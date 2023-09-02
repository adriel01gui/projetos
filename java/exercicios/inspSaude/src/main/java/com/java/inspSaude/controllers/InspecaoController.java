package com.java.inspSaude.controllers;

import com.java.inspSaude.dto.InspecaoDTO;
import com.java.inspSaude.repositories.InspecaoRepository;
import com.java.inspSaude.services.InspecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inspecao")
public class InspecaoController {

    @Autowired
    private InspecaoService inspecaoService;

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody InspecaoDTO inspecaoDTO) {
        try {
            inspecaoService.salvar(inspecaoDTO);
            return ResponseEntity.ok("Inspecao salva com sucesso");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
