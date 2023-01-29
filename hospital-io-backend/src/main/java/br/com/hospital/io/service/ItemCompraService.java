package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.ItemCompra;
import br.com.hospital.io.model.dto.ItemCompraDTO;
import br.com.hospital.io.repository.ItemCompraRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class ItemCompraService {
	@Autowired
	ItemCompraRepository itemCompraRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<ItemCompra>findAll() {
		List<ItemCompra>lista = itemCompraRepository.findAll();
		return lista;
	}

	public ItemCompra create(ItemCompraDTO itemCompraDTO) {
		findById(itemCompraDTO.getId());
		return itemCompraRepository.save(mapper.map(itemCompraDTO, ItemCompra.class));
	}

	public Optional<ItemCompra> findById(long id) {
		Optional<ItemCompra> ItemCompra = itemCompraRepository.findById(id);
		return Optional.ofNullable(ItemCompra.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public ItemCompra update(ItemCompraDTO itemCompraDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
