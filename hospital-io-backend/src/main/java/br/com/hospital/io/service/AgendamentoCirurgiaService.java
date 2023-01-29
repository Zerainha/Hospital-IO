package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.AgendamentoCirurgia;
import br.com.hospital.io.model.dto.AgendamentoCirurgiaDTO;
import br.com.hospital.io.repository.AgendamentoCirurgiaRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class AgendamentoCirurgiaService {
	@Autowired
	AgendamentoCirurgiaRepository agendamentoCirurgiaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<AgendamentoCirurgia>findAll() {
		List<AgendamentoCirurgia>lista = agendamentoCirurgiaRepository.findAll();
		return lista;
	}

	public AgendamentoCirurgia create(AgendamentoCirurgiaDTO agendamentoCirurgiaDTO) {
		findById(agendamentoCirurgiaDTO.getId());
		return agendamentoCirurgiaRepository.save(mapper.map(agendamentoCirurgiaDTO, AgendamentoCirurgia.class));
	}

	public Optional<AgendamentoCirurgia> findById(long id) {
		Optional<AgendamentoCirurgia> AgendamentoCirurgia = agendamentoCirurgiaRepository.findById(id);
		return Optional.ofNullable(AgendamentoCirurgia.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public AgendamentoCirurgia update(AgendamentoCirurgiaDTO agendamentoCirurgiaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
