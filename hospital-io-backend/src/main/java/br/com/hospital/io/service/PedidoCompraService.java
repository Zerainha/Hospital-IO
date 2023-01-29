package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Compra;
import br.com.hospital.io.model.dto.CompraDTO;
import br.com.hospital.io.repository.CompraRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoCompraService {
	@Autowired
	CompraRepository compraRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Compra>findAll() {
		List<Compra>lista = compraRepository.findAll();
		return lista;
	}

	public Compra create(CompraDTO compraDTO) {
		findById(compraDTO.getId());
		return compraRepository.save(mapper.map(compraDTO, Compra.class));
	}

	public Optional<Compra> findById(long id) {
		Optional<Compra> compra = compraRepository.findById(id);
		return Optional.ofNullable(compra.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Compra update(CompraDTO compraDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
