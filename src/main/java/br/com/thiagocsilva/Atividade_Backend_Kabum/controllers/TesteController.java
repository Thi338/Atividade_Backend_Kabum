package br.com.thiagocsilva.Atividade_Backend_Kabum.controllers;

import br.com.thiagocsilva.Atividade_Backend_Kabum.dtos.FreteDTO;
import br.com.thiagocsilva.Atividade_Backend_Kabum.models.OpcoesFrete;
import br.com.thiagocsilva.Atividade_Backend_Kabum.models.Produto;
import br.com.thiagocsilva.Atividade_Backend_Kabum.services.OpcoesFreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TesteController {

    @Autowired
    private OpcoesFreteService service;

    @GetMapping("/")
    public ResponseEntity<List<OpcoesFrete>> getAll() {
        List<OpcoesFrete> opcoesFreteList = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(opcoesFreteList);
    }

    @PostMapping("/")
    public ResponseEntity<Object> calcularFrete(@RequestBody Produto produto) {

        List<Integer> listaVazia = new ArrayList<>();

        if (produto.getPeso() > 0 && produto.getAltura() >= 10 && produto.getAltura() <= 200) {
            Double valor_frete = produto.getPeso() * 0.3 / 10;
            FreteDTO freteDTO = new FreteDTO("Entrega Ninja", valor_frete, 6);
            return ResponseEntity.status(HttpStatus.OK).body(freteDTO);
        }

        if (produto.getPeso() > 0 && produto.getLargura() >= 6 && produto.getLargura() <= 140) {
            Double valor_frete = produto.getPeso() * 0.2 / 10;
            FreteDTO freteDTO = new FreteDTO("Entrega KaBuM", valor_frete, 4);
            return ResponseEntity.status(HttpStatus.OK).body(freteDTO);
        }
            return ResponseEntity.status(HttpStatus.OK).body(listaVazia);

    }
}
