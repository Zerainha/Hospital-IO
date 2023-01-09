package br.com.hospital.io.model.dto;

import java.time.LocalDate;

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
public class PacienteDTO{
	@JsonIgnore
	private Long id;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private LocalDate dataNascimento;
	@NotBlank
	private String cpf;
	@NotBlank
	private String telefone;
	@NotBlank
	private String email;
	@NotBlank
	private String rua;
	@NotBlank
	private String bairro;
	@NotBlank
	private String numero_rua;
	@NotBlank
	private String cidade;
	@NotBlank
	private String cep;
	@NotBlank
	private String uf;
	@NotBlank
	private String estadoCivil;
	@NotBlank
	private String sexo;
	
}
