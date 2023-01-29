package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Caixa;
import br.com.hospital.io.model.dto.CaixaDTO;
import br.com.hospital.io.repository.CaixaRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class CaixaService {
	@Autowired
	CaixaRepository caixaRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Caixa>findAll() {
		List<Caixa>lista = caixaRepository.findAll();
		return lista;
	}

	public Caixa create(CaixaDTO caixaDTO) {
		findById(caixaDTO.getId());
		return caixaRepository.save(mapper.map(caixaDTO, Caixa.class));
	}

	public Optional<Caixa> findById(long id) {
		Optional<Caixa> Caixa = caixaRepository.findById(id);
		return Optional.ofNullable(Caixa.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Caixa update(CaixaDTO caixaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
