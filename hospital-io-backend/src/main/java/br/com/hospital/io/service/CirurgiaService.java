package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Cirurgia;
import br.com.hospital.io.model.dto.CirurgiaDTO;
import br.com.hospital.io.repository.CirurgiaRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class CirurgiaService {
	@Autowired
	CirurgiaRepository cirurgiaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Cirurgia>findAll() {
		List<Cirurgia>lista = cirurgiaRepository.findAll();
		return lista;
	}

	public Cirurgia create(CirurgiaDTO cirurgiaDTO) {
		findById(cirurgiaDTO.getId());
		return cirurgiaRepository.save(mapper.map(cirurgiaDTO, Cirurgia.class));
	}

	public Optional<Cirurgia> findById(long id) {
		Optional<Cirurgia> Cirurgia = cirurgiaRepository.findById(id);
		return Optional.ofNullable(Cirurgia.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Cirurgia update(CirurgiaDTO cirurgiaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
