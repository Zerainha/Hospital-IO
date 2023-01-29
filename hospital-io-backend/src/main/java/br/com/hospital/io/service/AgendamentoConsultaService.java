package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.AgendamentoConsulta;
import br.com.hospital.io.model.dto.AgendamentoConsultaDTO;
import br.com.hospital.io.repository.AgendamentoConsultaRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class AgendamentoConsultaService {
	@Autowired
	AgendamentoConsultaRepository AgendamentoConsultaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<AgendamentoConsulta>findAll() {
		List<AgendamentoConsulta>lista = AgendamentoConsultaRepository.findAll();
		return lista;
	}

	public AgendamentoConsulta create(AgendamentoConsultaDTO agendamentoConsultaDTO) {
		findById(agendamentoConsultaDTO.getId());
		return AgendamentoConsultaRepository.save(mapper.map(agendamentoConsultaDTO, AgendamentoConsulta.class));
	}

	public Optional<AgendamentoConsulta> findById(long id) {
		Optional<AgendamentoConsulta> AgendamentoConsulta = AgendamentoConsultaRepository.findById(id);
		return Optional.ofNullable(AgendamentoConsulta.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public AgendamentoConsulta update(AgendamentoConsultaDTO AgendamentoConsultaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
