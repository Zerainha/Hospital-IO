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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "enfermeira")
public class Enfermeira implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_completo", nullable = false)
	private String nomeCompleto;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "nome_usuario", nullable = false)
	private String nomeUsuario;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "celular", nullable = false)
	private String celular;
	
	@Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;
	
	@Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	
}
