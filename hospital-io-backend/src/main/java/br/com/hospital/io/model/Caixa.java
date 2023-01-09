package br.com.hospital.io.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "caixa")
public class Caixa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_abertura", nullable = false)
	private LocalDateTime dataAbertura;
	
	@Column(name = "data_fechamento", nullable = false)
	private LocalDateTime dataFechamento;
	
	@Column(name = "valor_inicial", nullable = false)
	private Double valorInicial;
	
	@Column(name = "valor_final", nullable = false) 
	private Double valorFinal;
	
	@Column(name = "valor_fechamento", nullable = false) //serve para comparar com o valor final
	private Double valorFechamento;
	
	@Column(name = "funcionario_abertura", nullable = false)
	private String funcionarioAberturaCaixa;
	
	@Column(name = "funcionario_fechamento", nullable = false)
	private String funcionariofechamentoCaixa;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@Column(name = "observacao", nullable = false)
	private String observacao; //caso exista incongruencia com o fechamento de caixa. obrigatorio ter observação
	
}
