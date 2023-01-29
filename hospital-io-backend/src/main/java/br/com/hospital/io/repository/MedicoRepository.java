package br.com.hospital.io.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hospital.io.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{
	Optional<Medico> findByEmail(String email);
}
