package br.com.hospital.io.model;

import java.io.Serializable;

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
@Table(name = "visita")
public class Visita implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_completo", nullable = false, length = 100)
	private String nomeCompleto;
	@Column(name = "cpf", nullable = false, length = 14)
	private String cpf;
	@Column(name = "telefone", nullable = false, length = 100)
	private String telefone;
	@Column(name = "email", nullable = false, length = 20)
	private String email;
	@Column(name = "rua", nullable = false, length = 100)
	private String rua;
	@Column(name = "bairro", nullable = false, length = 100)
	private String bairro;
	@Column(name = "numeroRua", nullable = false, length = 100)
	private String numero_rua;
	@Column(name = "cidade", nullable = false, length = 10)
	private String cidade;
	@Column(name = "cep", nullable = false, length = 10)
	private String cep;
	@Column(name = "uf", nullable = false, length = 2)
	private String uf;
	@Column(name = "sexo", nullable = false, length = 100)
	private String sexo;
	
}
