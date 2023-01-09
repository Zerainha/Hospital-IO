package br.com.hospital.io.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pagamento")
public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo_pagamento", nullable = false)
	private String tipoPagamento;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	@Column(name = "data_hora_pagamento", nullable = false)
	private LocalDateTime dataHoraPagamento;
	
	@OneToOne
    @JoinColumn(name= "fk_agendamento_consulta_id")
    private AgendamentoConsulta agendamentoConsulta;
	
	@ManyToOne
    @JoinColumn(name= "fk_caixa_id")
    private Caixa caixa;
}
