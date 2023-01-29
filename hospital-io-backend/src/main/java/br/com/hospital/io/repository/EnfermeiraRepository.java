package br.com.hospital.io.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hospital.io.model.Enfermeira;

@Repository
public interface EnfermeiraRepository extends JpaRepository<Enfermeira, Long>{
	Optional<Enfermeira> findByEmail(String email);
}
