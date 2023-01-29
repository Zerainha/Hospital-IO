package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Paciente;
import br.com.hospital.io.model.dto.PacienteDTO;
import br.com.hospital.io.repository.PacienteRepository;
import br.com.hospital.io.service.exceptions.EmailJaExistenteException;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Paciente>findAll() {
		List<Paciente>lista = pacienteRepository.findAll();
		return lista;
	}

	public Paciente create(PacienteDTO pacienteDTO) {
		findByEmail(pacienteDTO);
		return pacienteRepository.save(mapper.map(pacienteDTO, Paciente.class));
	}

	public Optional<Paciente> findById(long id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		return Optional.ofNullable(paciente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Paciente update(PacienteDTO PacienteDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private void findByEmail(PacienteDTO pacienteDTO){
		
		Optional<Paciente> paciente = pacienteRepository.findByEmail(pacienteDTO.getEmail());
		if(paciente.isPresent()){
			throw new EmailJaExistenteException("Email ja Cadastrado");
		}
		
	}
}
