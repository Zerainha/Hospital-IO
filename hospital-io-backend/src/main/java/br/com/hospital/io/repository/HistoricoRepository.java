package br.com.hospital.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hospital.io.model.HistoricoCompra;

@Repository
public interface HistoricoRepository extends JpaRepository<HistoricoCompra, Long>{

}
