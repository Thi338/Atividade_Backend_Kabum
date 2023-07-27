package br.com.thiagocsilva.Atividade_Backend_Kabum.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double altura;

    @Column(nullable = false)
    private Double largura;

    @Column(nullable = false)
    private Double peso;
}
