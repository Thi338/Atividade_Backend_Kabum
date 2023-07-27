package br.com.thiagocsilva.Atividade_Backend_Kabum.controllers;

import br.com.thiagocsilva.Atividade_Backend_Kabum.models.OpcoesFrete;
import br.com.thiagocsilva.Atividade_Backend_Kabum.models.Produto;
import br.com.thiagocsilva.Atividade_Backend_Kabum.serviceImpl.FreteServiceImpl;
import br.com.thiagocsilva.Atividade_Backend_Kabum.serviceImpl.OpcoesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/", produces = {"application/json"})
@Tag(name = "atividade-backend-kabum")
public class FreteController {

    @Autowired
    private OpcoesServiceImpl opcoesService;

    @Autowired
    private FreteServiceImpl freteService;

    public FreteController(OpcoesServiceImpl opcoesService, FreteServiceImpl freteService) {
        this.opcoesService = opcoesService;
        this.freteService = freteService;
    }

    @GetMapping("/opcoes-frete")
    @Operation(summary = "Traz a listagem de opções de frete.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A listagem foi trazida com sucesso"),
            @ApiResponse(responseCode = "404", description = "A listagem foi não pôde ser retornada"),
            @ApiResponse(responseCode = "500", description = "Servidor indisponível")
    })
    public ResponseEntity<List<OpcoesFrete>> getAll() {
        List<OpcoesFrete> opcoesFreteList = this.opcoesService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(opcoesFreteList);
    }


    @Operation(summary = "Consulta os valores de frete para cada transpostadora existente " +
            "conforme as especificações de altura, largura e peso do produto.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A consulta foi realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "A consulta foi não pôde ser retornada"),
            @ApiResponse(responseCode = "500", description = "Servidor indisponível")
    })
    @PostMapping
    public ResponseEntity<Object> calcularFrete(@RequestBody Produto produto) {
             return this.freteService.calcularFrete(produto);
    }

}
