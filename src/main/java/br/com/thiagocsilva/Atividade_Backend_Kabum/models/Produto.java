package br.com.thiagocsilva.Atividade_Backend_Kabum.models;

import br.com.thiagocsilva.Atividade_Backend_Kabum.dtos.DimensaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Long id;

    private DimensaoDTO dimensao;

    private Double peso;

}
