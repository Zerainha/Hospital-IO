package br.com.hospital.io.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "agendamento_visita")
public class AgendamentoVisita implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descricao", nullable = false)
	private String descricao;
	@Column(name = "data_hora_visita", nullable = false)
	private LocalDateTime dataHoraVisita;
	
	@ManyToOne
    @JoinColumn(name= "fk_paciente_id")
    private Paciente paciente;
	
	@ManyToOne
    @JoinColumn(name= "fk_visita_id")
    private Visita visita;
	
}
