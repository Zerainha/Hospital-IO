package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Fornecedor;
import br.com.hospital.io.model.dto.FornecedorDTO;
import br.com.hospital.io.repository.FornecedorRepository;
import br.com.hospital.io.service.exceptions.EmailJaExistenteException;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Fornecedor>findAll() {
		List<Fornecedor>lista = fornecedorRepository.findAll();
		return lista;
	}

	public Fornecedor create(FornecedorDTO fornecedorDTO) {
		findByEmail(fornecedorDTO);
		return fornecedorRepository.save(mapper.map(fornecedorDTO, Fornecedor.class));
	}

	public Optional<Fornecedor> findById(long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return Optional.ofNullable(fornecedor.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Fornecedor update(FornecedorDTO FornecedorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private void findByEmail(FornecedorDTO FornecedorDTO){
		
		Optional<Fornecedor> Fornecedor = fornecedorRepository.findByEmail(FornecedorDTO.getEmail());
		if(Fornecedor.isPresent()){
			throw new EmailJaExistenteException("Email ja Cadastrado");
		}
		
	}
}
