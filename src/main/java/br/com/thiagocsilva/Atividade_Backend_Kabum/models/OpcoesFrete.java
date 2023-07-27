package br.com.thiagocsilva.Atividade_Backend_Kabum.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "opcoes_frete")
public class OpcoesFrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double constante_calculo_frete;

    @Column(nullable = false)
    private Integer altura_min;

    @Column(nullable = false)
    private Integer altura_max;

    @Column(nullable = false)
    private Integer largura_min;

    @Column(nullable = false)
    private Integer largura_max;

    @Column(nullable = false)
    private Integer prazo_dias;

}
