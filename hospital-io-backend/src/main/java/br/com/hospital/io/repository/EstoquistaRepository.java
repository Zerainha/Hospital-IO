package br.com.hospital.io.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hospital.io.model.Estoquista;

@Repository
public interface EstoquistaRepository  extends JpaRepository<Estoquista, Long>{
	Optional<Estoquista> findByEmail(String email);
}
