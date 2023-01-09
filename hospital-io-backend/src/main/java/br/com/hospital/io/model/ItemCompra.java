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
@Table(name = "item_compra")
public class ItemCompra implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	@Column(name = "quantidade", nullable = false)
	private double quantidade;
	@Column(name = "unidade_medida", nullable = false, length = 100)
	private String unidadeMedida;
	@Column(name = "status", nullable = false)
	private boolean status; // se 1 item estiver com o status false quer dizer que a quantidade do pedido de compra é diferende do itens compra
	 
	@ManyToOne
    @JoinColumn(name= "fk_estoque_id")
    private Estoque estoque;
	
	@ManyToOne
    @JoinColumn(name= "fk_compra_id")
    private Compra compra;
	
}
