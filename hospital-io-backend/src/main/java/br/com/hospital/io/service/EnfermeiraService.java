package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Enfermeira;
import br.com.hospital.io.model.dto.EnfermeiraDTO;
import br.com.hospital.io.repository.EnfermeiraRepository;
import br.com.hospital.io.service.exceptions.EmailJaExistenteException;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class EnfermeiraService {
	@Autowired
	EnfermeiraRepository enfermeiraRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Enfermeira>findAll() {
		List<Enfermeira>lista = enfermeiraRepository.findAll();
		return lista;
	}

	public Enfermeira create(EnfermeiraDTO enfermeiraDTO) {
		findByEmail(enfermeiraDTO);
		return enfermeiraRepository.save(mapper.map(enfermeiraDTO, Enfermeira.class));
	}

	public Optional<Enfermeira> findById(long id) {
		Optional<Enfermeira> enfermeira = enfermeiraRepository.findById(id);
		return Optional.ofNullable(enfermeira.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Enfermeira update(EnfermeiraDTO enfermeiraDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private void findByEmail(EnfermeiraDTO enfermeiraDTO){
		
		Optional<Enfermeira> Enfermeira = enfermeiraRepository.findByEmail(enfermeiraDTO.getEmail());
		if(Enfermeira.isPresent()){
			throw new EmailJaExistenteException("Email ja Cadastrado");
		}
		
	}
}
