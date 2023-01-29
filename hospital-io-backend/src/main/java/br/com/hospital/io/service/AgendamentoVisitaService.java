package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.AgendamentoVisita;
import br.com.hospital.io.model.dto.AgendamentoVisitaDTO;
import br.com.hospital.io.repository.AgendamentoVisitaRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class AgendamentoVisitaService {
	@Autowired
	AgendamentoVisitaRepository agendamentoVisitaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<AgendamentoVisita>findAll() {
		List<AgendamentoVisita>lista = agendamentoVisitaRepository.findAll();
		return lista;
	}

	public AgendamentoVisita create(AgendamentoVisitaDTO agendamentoVisitaDTO) {
		findById(agendamentoVisitaDTO.getId());
		return agendamentoVisitaRepository.save(mapper.map(agendamentoVisitaDTO, AgendamentoVisita.class));
	}

	public Optional<AgendamentoVisita> findById(long id) {
		Optional<AgendamentoVisita> AgendamentoVisita = agendamentoVisitaRepository.findById(id);
		return Optional.ofNullable(AgendamentoVisita.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public AgendamentoVisita update(AgendamentoVisitaDTO agendamentoVisitaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
