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
public class EstoqueDTO{
	
	@JsonIgnore
	private Long id;
	@NotBlank
	private String produto;
	@NotBlank
	private double quantidade;
	@NotBlank
	private double quanidadeMinima;
	@NotBlank
	private boolean status;
		
	
}
