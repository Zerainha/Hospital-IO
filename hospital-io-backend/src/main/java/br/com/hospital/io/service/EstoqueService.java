package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Estoque;
import br.com.hospital.io.model.dto.EstoqueDTO;
import br.com.hospital.io.repository.EstoqueRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class EstoqueService {
	@Autowired
	EstoqueRepository estoqueRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Estoque>findAll() {
		List<Estoque>lista = estoqueRepository.findAll();
		return lista;
	}

	public Estoque create(EstoqueDTO estoqueDTO) {
		findById(estoqueDTO.getId());
		return estoqueRepository.save(mapper.map(estoqueDTO, Estoque.class));
	}

	public Optional<Estoque> findById(long id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		return Optional.ofNullable(estoque.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Estoque update(EstoqueDTO estoqueDTO) {
		if(!estoqueRepository.existsById(estoqueDTO.getId()))
		{
			throw new ObjectNotFoundException(null);
		}
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	

	
}
