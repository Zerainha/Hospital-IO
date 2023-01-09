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
@Table(name = "historico_compra")
public class HistoricoCompra implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	@Column(name = "data_hora_finalizacao_compra", nullable = false, length = 100)
	private LocalDateTime dataHoraFinalizacaoCompra;
	
	@ManyToOne
    @JoinColumn(name= "fk_compra_id")
    private Compra compra;
	
}
