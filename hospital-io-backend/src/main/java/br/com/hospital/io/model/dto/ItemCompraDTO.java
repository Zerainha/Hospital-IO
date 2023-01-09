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
public class ItemCompraDTO{
	@JsonIgnore
	private Long id;
	@NotBlank
	private String descricao;
	@NotBlank
	private double quantidade;
	@NotBlank
	private String unidadeMedida;
	@NotBlank
	private boolean status; // se 1 item estiver com o status false quer dizer que a quantidade do pedido de compra é diferende do itens compra

	
}
