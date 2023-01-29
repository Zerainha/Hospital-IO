package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Secretaria;
import br.com.hospital.io.model.dto.SecretariaDTO;
import br.com.hospital.io.repository.SecretariaRepository;
import br.com.hospital.io.service.exceptions.EmailJaExistenteException;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class SecretariaService {
	@Autowired
	SecretariaRepository secretariaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Secretaria>findAll() {
		List<Secretaria>lista = secretariaRepository.findAll();
		return lista;
	}

	public Secretaria create(SecretariaDTO secretariaDTO) {
		findByEmail(secretariaDTO);
		return secretariaRepository.save(mapper.map(secretariaDTO, Secretaria.class));
	}

	public Optional<Secretaria> findById(long id) {
		Optional<Secretaria> Secretaria = secretariaRepository.findById(id);
		return Optional.ofNullable(Secretaria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Secretaria update(SecretariaDTO SecretariaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private void findByEmail(SecretariaDTO secretariaDTO){
		
		Optional<Secretaria> secretaria = secretariaRepository.findByEmail(secretariaDTO.getEmail());
		if(secretaria.isPresent()){
			throw new EmailJaExistenteException("Email ja Cadastrado");
		}
		
	}
}
