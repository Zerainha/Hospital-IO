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
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estoque")
public class Estoque implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "produto", nullable = false)
	private String produto;
	@Column(name = "quantidade", nullable = false)
	private double quantidade;
	@Column(name = "quantidade_minima", nullable = false)
	private double quanidadeMinima;
	@Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;
	@Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "FK_estoquista_id")
	private Estoquista estoquista;
		
	
}
