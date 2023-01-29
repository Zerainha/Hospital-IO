package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Estoquista;
import br.com.hospital.io.model.dto.EstoquistaDTO;
import br.com.hospital.io.repository.EstoquistaRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class EstoquistaService {
	@Autowired
	EstoquistaRepository estoquistaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Estoquista>findAll() {
		List<Estoquista>lista = estoquistaRepository.findAll();
		return lista;
	}

	public Estoquista create(EstoquistaDTO estoquistaDTO) {
		findById(estoquistaDTO.getId());
		return estoquistaRepository.save(mapper.map(estoquistaDTO, Estoquista.class));
	}

	public Optional<Estoquista> findById(long id) {
		Optional<Estoquista> Estoquista = estoquistaRepository.findById(id);
		return Optional.ofNullable(Estoquista.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Estoquista update(EstoquistaDTO estoquistaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
