package br.com.hospital.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hospital.io.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long>{

}
