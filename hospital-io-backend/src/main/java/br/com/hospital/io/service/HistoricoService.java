package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.HistoricoCompra;
import br.com.hospital.io.model.dto.HistoricoCompraDTO;
import br.com.hospital.io.repository.HistoricoRepository;

import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class HistoricoService {
	
	@Autowired
	HistoricoRepository historicoCompraRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<HistoricoCompra>findAll() {
		List<HistoricoCompra>lista = historicoCompraRepository.findAll();
		return lista;
	}

	public HistoricoCompra create(HistoricoCompraDTO historicoCompraDTO) {
		findById(historicoCompraDTO.getId());
		return historicoCompraRepository.save(mapper.map(historicoCompraDTO, HistoricoCompra.class));
	}

	public Optional<HistoricoCompra> findById(long id) {
		Optional<HistoricoCompra> HistoricoCompra = historicoCompraRepository.findById(id);
		return Optional.ofNullable(HistoricoCompra.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public HistoricoCompra update(HistoricoCompraDTO historicoCompraDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
	}
	
}
