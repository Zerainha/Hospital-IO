package br.com.hospital.io.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hospital.io.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	Optional<Paciente> findByEmail(String email);
}
