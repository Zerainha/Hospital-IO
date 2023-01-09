package br.com.hospital.io.model.dto;

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
public class CompraDTO{
	@JsonIgnore
	private Long id;
	@NotBlank
	private double valor;
	@NotBlank
	private String numeroNotaFiscal;
	@NotBlank
	private boolean status;// compra finalizada/nao finalizada 
	
}
