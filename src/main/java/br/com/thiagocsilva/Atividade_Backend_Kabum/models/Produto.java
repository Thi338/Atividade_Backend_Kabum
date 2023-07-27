package br.com.thiagocsilva.Atividade_Backend_Kabum.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Long id;

    private Double altura;

    private Double largura;

    private Double peso;
}
