package br.com.hospital.io.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hospital.io.model.Secretaria;

@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long>{
	Optional<Secretaria> findByEmail(String email);
}
