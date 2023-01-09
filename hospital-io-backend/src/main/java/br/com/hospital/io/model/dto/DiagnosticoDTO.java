package br.com.hospital.io.model.dto;

import java.time.LocalDateTime;

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
public class DiagnosticoDTO {
	@JsonIgnore
	private Long id;
	@NotBlank
	private String sintomas;
	@NotBlank
	private String descricao;
	@NotBlank
	private LocalDateTime dataHoraDiagnostico;
}
