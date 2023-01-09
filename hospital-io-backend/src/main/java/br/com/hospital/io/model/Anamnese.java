package br.com.hospital.io.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "anamnese")
public class Anamnese implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@Column(name = "altura", nullable = false)
	private double altura;
	@Column(name = "peso", nullable = false)
	private double peso;
	@Column(name = "ocupacao", nullable = false, length = 200)
	private String ocupacao;
	@Column(name = "fumante", nullable = false)
	private boolean fumante;
	@Column(name = "distubio_circulatorio", nullable = false)
	private boolean disturbioCirculatorio;
	@Column(name = "epilepsia", nullable = false)
	private boolean epilepsia;
	@Column(name = "intestino_regular", nullable = false)
	private boolean intestinoRegular;
	@Column(name = "diabetes", nullable = false)
	private boolean diabetes;
	@Column(name = "tipo_diabetes", nullable = false)
	private String tipoDiabetes;
	@Column(name = "tratamento_medico", nullable = false, length = 20)
    private boolean tratamentoMedico;
	@Column(name = "tipo_tratamento", nullable = false, length = 200)
    private String tipoTratMedico;
	@Column(name = "cirurgia_recente", nullable = false)
    private boolean cirurgiaRecente;
	@Column(name = "tipo_cirurgia", nullable = false, length = 200)
    private String tipoCirurgia;
	@Column(name = "problema_pele", nullable = false)
    private boolean problemaPele;
	@Column(name = "tipo_problema_pele", nullable = false, length = 200)
    private String tipoProblemaPele;
	@Column(name = "protese_corporal_facial", nullable = false)
	private boolean proteseCorporalFacial;
	@Column(name = "tipo_protese", nullable = false, length = 200)
	private String tipoProtese;
	@Column(name = "algum_outro_problema", nullable = false)
	private boolean algumOutroProblema;
	@Column(name = "tipo_outro_problema", nullable = false, length = 200)
	private String tipoOutroProblema;
	@Column(name = "alteracoes_cardiacas", nullable = false)
	private boolean alteracoesCardiacas;
	@Column(name = "disturbio_hormonal", nullable = false)
	private boolean disturbioHormonal;
	@Column(name = "hipo_hipertensa_arterial", nullable = false)
	private boolean hipoHipertensalArterial;
	@Column(name = "disturbio_renal", nullable = false)
	private boolean disturbioRenal;
	@Column(name = "variazes_lesoes", nullable = false)
	private boolean varizesLesoes;
	@Column(name = "tipo_lesao", nullable = false, length = 200)
	private String tipoLesao;
	@Column(name = "gestante", nullable = false)
    private boolean gestante;
	@Column(name = "alergia", nullable = false)
    private boolean alergia;
	@Column(name = "tipo_alergia", nullable = false, length = 200)
    private String tipoAlergia;
	@Column(name = "tumor_lesap_pre_cancerosa", nullable = false)
    private boolean tumorLesaoPreCancerosa;
	@Column(name = "tipo_tumor_lesao_pre_cancerosa", nullable = false, length = 200)
    private String tipoTumorLesaoPreCancerosa;
	@Column(name = "probs_ortopedicos", nullable = false)
    private boolean probsOrtopedicos;
	@Column(name = "tipo_prob_ortopodicos", nullable = false, length = 200)
    private String tipoProbsOrtopedicos;
	@Column(name = "utiliza_acidos", nullable = false)
	private boolean utilizaAcidos;
	@Column(name = "tipo_acido", nullable = false, length = 200)
	private String tipoAcido;
	
	@ManyToOne
    @JoinColumn(name= "fk_paciente_id")
    private Paciente paciente;
	
}
