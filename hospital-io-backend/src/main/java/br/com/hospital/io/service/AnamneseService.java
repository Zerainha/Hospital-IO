package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Anamnese;
import br.com.hospital.io.model.dto.AnamneseDTO;
import br.com.hospital.io.repository.AnamneseRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class AnamneseService {
	@Autowired
	AnamneseRepository anamneseRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Anamnese>findAll() {
		List<Anamnese>lista =anamneseRepository.findAll();
		return lista;
	}

	public Anamnese create(AnamneseDTO anamneseDTO) {
		findById(anamneseDTO.getId());
		return anamneseRepository.save(mapper.map(anamneseDTO, Anamnese.class));
	}

	public Optional<Anamnese> findById(long id) {
		Optional<Anamnese> anamnese = anamneseRepository.findById(id);
		return Optional.ofNullable(anamnese.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Anamnese update(AnamneseDTO anamneseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
