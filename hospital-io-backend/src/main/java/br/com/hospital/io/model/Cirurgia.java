package br.com.hospital.io.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.hospital.io.model.dto.AgendamentoCirurgiaDTO;
import br.com.hospital.io.model.dto.EnfermeiraDTO;
import br.com.hospital.io.model.dto.MedicoDTO;
import br.com.hospital.io.model.dto.PacienteDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "cirurgia")
public class Cirurgia implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_cirurgia", nullable = false)
    private LocalDateTime dataCadastro;
	
	@Column(name = "situacao", nullable = false)
    private String situacao; // para saber se morreu mas passa bem
	
	@ManyToOne
    @JoinColumn(name= "fk_medico_id")
    private MedicoDTO medico;
	
	@ManyToOne
    @JoinColumn(name= "fk_paciente_id")
    private PacienteDTO paciente;
	
	@OneToOne
    @JoinColumn(name= "fk_agendamento_cirurgia_id")
    private AgendamentoCirurgiaDTO agendamentoCirurgia;
	
	@ManyToMany
	@JoinTable(name="cirurgia_has_enfermeira",
				joinColumns = @JoinColumn(name = "fk_cirurgia_id"),
			 	inverseJoinColumns = @JoinColumn(name="fk_enfermeira_id"))
	private List<EnfermeiraDTO>listaEnfermeiras = new ArrayList<>();
}
