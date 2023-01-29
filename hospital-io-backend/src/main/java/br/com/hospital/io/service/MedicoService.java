package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Medico;
import br.com.hospital.io.model.dto.MedicoDTO;
import br.com.hospital.io.repository.MedicoRepository;
import br.com.hospital.io.service.exceptions.EmailJaExistenteException;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class MedicoService {
	@Autowired
	MedicoRepository medicoRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Medico>findAll() {
		List<Medico>lista = medicoRepository.findAll();
		return lista;
	}

	public Medico create(MedicoDTO medicoDTO) {
		findByEmail(medicoDTO);
		return medicoRepository.save(mapper.map(medicoDTO, Medico.class));
	}

	public Optional<Medico> findById(long id) {
		Optional<Medico> medico = medicoRepository.findById(id);
		return Optional.ofNullable(medico.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Medico update(MedicoDTO medicoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private void findByEmail(MedicoDTO medicoDTO){
		
		Optional<Medico> Medico = medicoRepository.findByEmail(medicoDTO.getEmail());
		if(Medico.isPresent()){
			throw new EmailJaExistenteException("Email ja Cadastrado");
		}
		
	}
}
