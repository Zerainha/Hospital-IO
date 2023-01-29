package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Administrador;
import br.com.hospital.io.model.dto.AdministradorDTO;
import br.com.hospital.io.repository.AdministradorRepository;
import br.com.hospital.io.service.exceptions.EmailJaExistenteException;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;


@Service
public class AdministradorService {
	
	@Autowired
	AdministradorRepository administradorRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Administrador>findAll() {
		List<Administrador>lista =administradorRepository.findAll();
		return lista;
	}

	public Administrador create(AdministradorDTO administradorDTO) {
		findByEmail(administradorDTO);
		return administradorRepository.save(mapper.map(administradorDTO, Administrador.class));
	}

	public Optional<Administrador> findById(long id) {
		Optional<Administrador> administrador = administradorRepository.findById(id);
		return Optional.ofNullable(administrador.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Administrador update(AdministradorDTO administradorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private void findByEmail(AdministradorDTO administradorDTO){
		
		Optional<Administrador> Administrador = administradorRepository.findByEmail(administradorDTO.getEmail());
		if(Administrador.isPresent()){
			throw new EmailJaExistenteException("Email ja Cadastrado");
		}
		
	}
}
