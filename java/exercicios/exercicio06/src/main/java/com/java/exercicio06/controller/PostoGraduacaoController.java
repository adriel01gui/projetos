package com.java.exercicio06.controller;

import com.java.exercicio06.dto.MilitarDTO;
import com.java.exercicio06.entities.PostoGraduacao;
import com.java.exercicio06.services.PostoGraduacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postograduacao")
@Api(value = "", tags = "Militar", description = "")
public class PostoGraduacaoController {

    @Autowired
    private PostoGraduacaoService postoGraduacaoService;

    @GetMapping("/codigoMilitar/{codigoMilitar}")
    @ApiOperation(value = "Listar militares pelo codigo e nomePosto.", notes = "")
    public List<PostoGraduacao> buscarPorCodigoPedido(@PathVariable Integer codigoMilitar) {
        return postoGraduacaoService.buscarPorCodigoMilitar(codigoMilitar);
    }

    @GetMapping("/listarAgrupado")
    @ApiOperation(value = "Listar militar agrupado por postoGraduação.", notes = "")
    public List<MilitarDTO> listarAgrupado() {
        return postoGraduacaoService.listarDadosAgrupado();
    }

}

