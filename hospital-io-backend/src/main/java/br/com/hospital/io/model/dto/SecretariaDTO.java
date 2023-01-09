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
public class SecretariaDTO{
	@JsonIgnore
	private Long id;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private String cpf;
	@NotBlank
	private String userName;
	@NotBlank
	private String senha;
	@NotBlank
	private String email;
	@NotBlank
	private String celular;
	@NotBlank
	private String endereco;
	@NotBlank
	private String numeroRua;
	@NotBlank
	private String cidade;
	@NotBlank
	private String bairro;
	@NotBlank
	private String uf;
	@NotBlank
	private String cep;
	@NotBlank
	private String status;
}
