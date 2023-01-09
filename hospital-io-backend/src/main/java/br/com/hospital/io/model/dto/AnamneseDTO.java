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
public class AnamneseDTO{
	@JsonIgnore
	private Long id;
	@NotBlank
	private double altura;
	@NotBlank
	private double peso;
	@NotBlank
	private String ocupacao;
	@NotBlank
	private boolean fumante;
	@NotBlank
	private boolean disturbioCirculatorio;
	@NotBlank
	private boolean epilepsia;
	@NotBlank
	private boolean intestinoRegular;
	@NotBlank
	private boolean diabetes;
	@NotBlank
	private String tipoDiabetes;
	@NotBlank
	private boolean tratamentoMedico;
	@NotBlank
	private String tipoTratMedico;
	@NotBlank
	private boolean cirurgiaRecente;
	@NotBlank
	private String tipoCirurgia;
	@NotBlank
	private boolean problemaPele;
	@NotBlank
	private String tipoProblemaPele;
	@NotBlank
	private boolean proteseCorporalFacial;
	@NotBlank
	private String tipoProtese;
	@NotBlank
	private boolean algumOutroProblema;
	@NotBlank
	private String tipoOutroProblema;
	@NotBlank
	private boolean alteracoesCardiacas;
	@NotBlank
	private boolean disturbioHormonal;
	@NotBlank
	private boolean hipoHipertensalArterial;
	@NotBlank
	private boolean disturbioRenal;
	@NotBlank
	private boolean varizesLesoes;
	@NotBlank
	private String tipoLesao;
	@NotBlank
	private boolean gestante;
	@NotBlank
	private boolean alergia;
	@NotBlank
	private String tipoAlergia;
	@NotBlank
	private boolean tumorLesaoPreCancerosa;
	@NotBlank
	private String tipoTumorLesaoPreCancerosa;
	@NotBlank
	private boolean probsOrtopedicos;
	@NotBlank
	private String tipoProbsOrtopedicos;
	@NotBlank
	private boolean utilizaAcidos;
	@NotBlank
	private String tipoAcido;
	
}
