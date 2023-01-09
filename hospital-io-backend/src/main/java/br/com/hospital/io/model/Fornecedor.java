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
@Table(name = "fornecedor")
public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_empresa", nullable = false)
	private String nomeEmpresa;
	
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "celular", nullable = false)
	private String celular;
	
	@Column(name = "telefone", nullable = false)
	private String telefone;
	
	@Column(name = "endereco", nullable = false)
	private String endereco;
	
	@Column(name = "numero_rua", nullable = false)
	private String numeroRua;
	
	@Column(name = "cidade", nullable = false)
	private String cidade;
	
	@Column(name = "bairro", nullable = false)
	private String bairro;
	
	@Column(name = "uf", nullable = false)
	private String uf;
	
	@Column(name = "cep", nullable = false)
	private String cep;
	
	@Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;
	
	@Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;
	
	@Column(name = "status", nullable = false)
	private String status;
	
}
