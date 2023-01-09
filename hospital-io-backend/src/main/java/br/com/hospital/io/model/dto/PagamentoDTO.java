package br.com.hospital.io.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO{
	@JsonIgnore
	private Long id;
	@NotBlank
	private String tipoPagamento;
	@NotBlank
	private BigDecimal valor;
	
}
