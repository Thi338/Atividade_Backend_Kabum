package br.com.thiagocsilva.Atividade_Backend_Kabum.dtos;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public record FreteDTO(String nome, @NumberFormat(pattern = "##.00") BigDecimal valor_frete, Integer prazo_dias) {
}
