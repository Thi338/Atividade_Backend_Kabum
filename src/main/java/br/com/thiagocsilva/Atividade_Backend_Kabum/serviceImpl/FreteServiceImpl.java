package br.com.thiagocsilva.Atividade_Backend_Kabum.serviceImpl;

import br.com.thiagocsilva.Atividade_Backend_Kabum.dtos.FreteDTO;
import br.com.thiagocsilva.Atividade_Backend_Kabum.models.Produto;
import br.com.thiagocsilva.Atividade_Backend_Kabum.services.FreteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FreteServiceImpl implements FreteService {
    @Override
    public ResponseEntity<Object> calcularFrete(Produto produto) {
        List<Integer> listaVazia = new ArrayList<>();
        List<Object> listaDeOpcoes = new ArrayList<>();

        // Todos
        if (produto.getPeso() > 0 && produto.getAltura() >= 10 && produto.getAltura() <= 140 &&
                produto.getLargura() >= 6 && produto.getLargura() <= 140
        ) {
            Double valor_freteNinja = produto.getPeso() * 0.3 / 10;
            Double valor_freteKabum = produto.getPeso() * 0.2 / 10;

            FreteDTO freteDTO1 = new FreteDTO("Entrega Ninja", valor_freteNinja, 6);
            FreteDTO freteDTO2 = new FreteDTO("Entrega KaBuM", valor_freteKabum, 4);
            listaDeOpcoes.add(freteDTO1);
            listaDeOpcoes.add(freteDTO2);
            return ResponseEntity.status(HttpStatus.OK).body(listaDeOpcoes);
        }

        // Ninja
        if (produto.getPeso() > 0 && produto.getAltura() > 140 && produto.getAltura() <= 200
                && produto.getLargura() >= 6 && produto.getLargura() <= 140) {

            Double valor_frete = produto.getPeso() * 0.3 / 10;
            FreteDTO freteDTO = new FreteDTO("Entrega Ninja", valor_frete, 6);
            return ResponseEntity.status(HttpStatus.OK).body(freteDTO);
        }

        // Kabum
        if (produto.getPeso() > 0 && produto.getAltura() >= 5 && produto.getAltura() < 10 &&
                produto.getLargura() >= 13 && produto.getLargura() <= 125
        ) {

            Double valor_frete = produto.getPeso() * 0.3 / 10;
            FreteDTO freteDTO = new FreteDTO("Entrega KaBuM", valor_frete, 4);
            return ResponseEntity.status(HttpStatus.OK).body(freteDTO);
        }

        return ResponseEntity.status(HttpStatus.OK).body(listaVazia);
    }
}