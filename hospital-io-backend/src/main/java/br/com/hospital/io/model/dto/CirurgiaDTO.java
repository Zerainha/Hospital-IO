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
public class CirurgiaDTO{
	@JsonIgnore
	private Long id;
	@NotBlank
	private String situacao; // para saber se morreu mas passa bem

}
