package br.com.hospital.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hospital.io.model.Estoquista;


public interface EstoquistaRepository  extends JpaRepository<Estoquista, Long>{

}
