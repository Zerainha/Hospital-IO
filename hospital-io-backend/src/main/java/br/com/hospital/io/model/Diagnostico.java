package br.com.hospital.io.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diagnostico")
public class Diagnostico implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "sintomas", nullable = false)
	private String sintomas;
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "data_hora_diagnostico", nullable = false)
	private LocalDateTime dataHoraDiagnostico;
	
	@ManyToOne
    @JoinColumn(name= "fk_paciente_id")
    private Paciente paciente;
	
	@ManyToMany
	@JoinTable(name="diagnostico_has_medico",
				joinColumns = @JoinColumn(name = "fk_diagnostico_id"),
			 	inverseJoinColumns = @JoinColumn(name="fk_medico_id"))
	private List<Enfermeira>listaDiagnostico = new ArrayList<>();
}
