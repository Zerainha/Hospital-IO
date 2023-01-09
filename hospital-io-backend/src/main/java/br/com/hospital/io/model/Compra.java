package br.com.hospital.io.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "compra")
public class Compra implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data_hora_compra", nullable = false)
	private LocalDateTime dataHoraCompra;
	@Column(name = "valor", nullable = false)
	private double valor;
	@Column(name = "numero_nota_fiscal", nullable = false, length = 100)
	private String numeroNotaFiscal;
	@Column(name = "status", nullable = false)
	private boolean status;// compra finalizada/nao finalizada 
	  
	@ManyToOne
    @JoinColumn(name= "fk_fornecedor_id")
    private Fornecedor fornecedor;
	
	@ManyToOne
    @JoinColumn(name= "fk_estoquista_id")
    private Estoquista estoquista;
	
	@OneToMany(mappedBy = "compra")
	private List<ItemCompra>listaItensCompra;
	
}
