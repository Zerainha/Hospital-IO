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
@Table(name = "agendamento_cirurgia")
public class AgendamentoCirurgia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descricao", nullable = false)
	private String descricao;
	@Column(name = "data_hora_cirurgia", nullable = false)
	private LocalDateTime dataHoraCirurgia;
	@Column(name = "status", nullable = false)
	private String status; ///Agendado ou pendente
	
	@OneToOne
	@JoinColumn(name = "fk_cirurgia_id")
	private Cirurgia cirurgia;
	
	@ManyToMany
	@JoinTable(name="cirurgia_has_secretaria",
				joinColumns = @JoinColumn(name = "fk_cirurgia_id"),
			 	inverseJoinColumns = @JoinColumn(name="fk_secretaria_id"))
	private List<Enfermeira>listaEnfermeiras = new ArrayList<>();
	
	
	
}
