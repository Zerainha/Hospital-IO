package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Visita;
import br.com.hospital.io.model.dto.VisitaDTO;
import br.com.hospital.io.repository.VisitaRepository;
import br.com.hospital.io.service.exceptions.EmailJaExistenteException;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class VisitaService {
	@Autowired
	VisitaRepository visitaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Visita>findAll() {
		List<Visita>lista = visitaRepository.findAll();
		return lista;
	}

	public Visita create(VisitaDTO visitaDTO) {
		findByEmail(visitaDTO);
		return visitaRepository.save(mapper.map(visitaDTO, Visita.class));
	}

	public Optional<Visita> findById(long id) {
		Optional<Visita> visita = visitaRepository.findById(id);
		return Optional.ofNullable(visita.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Visita update(VisitaDTO visitaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private void findByEmail(VisitaDTO visitaDTO){
		
		Optional<Visita> visita = visitaRepository.findByEmail(visitaDTO.getEmail());
		if(visita.isPresent()){
			throw new EmailJaExistenteException("Email ja Cadastrado");
		}
		
	}
}
