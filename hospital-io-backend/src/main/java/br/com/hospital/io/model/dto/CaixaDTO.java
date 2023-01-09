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
public class CaixaDTO {
	@JsonIgnore
	private Long id;
	@NotBlank
	private Double valorInicial;
	@NotBlank
	private Double valorFinal;
	@NotBlank
	private Double valorFechamento;
	@NotBlank
	private String funcionarioAberturaCaixa;
	@NotBlank
	private String funcionariofechamentoCaixa;
	@NotBlank
	private boolean status;
	@NotBlank
	private String observacao; //caso exista incongruencia com o fechamento de caixa. obrigatorio ter observação
	
}
