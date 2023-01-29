package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Diagnostico;
import br.com.hospital.io.model.dto.DiagnosticoDTO;
import br.com.hospital.io.repository.DiagnosticoRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class DiagnosticoService {
	@Autowired
	DiagnosticoRepository diagnosticoRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Diagnostico>findAll() {
		List<Diagnostico>lista = diagnosticoRepository.findAll();
		return lista;
	}

	public Diagnostico create(DiagnosticoDTO diagnosticoDTO) {
		findById(diagnosticoDTO.getId());
		return diagnosticoRepository.save(mapper.map(diagnosticoDTO, Diagnostico.class));
	}

	public Optional<Diagnostico> findById(long id) {
		Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(id);
		return Optional.ofNullable(diagnostico.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Diagnostico update(DiagnosticoDTO diagnosticoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
