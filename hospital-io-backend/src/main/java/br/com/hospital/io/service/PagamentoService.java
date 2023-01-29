package br.com.hospital.io.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hospital.io.model.Pagamento;
import br.com.hospital.io.model.dto.PagamentoDTO;
import br.com.hospital.io.repository.PagamentoRepository;
import br.com.hospital.io.service.exceptions.ObjectNotFoundException;

@Service
public class PagamentoService {
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Pagamento>findAll() {
		List<Pagamento>lista = pagamentoRepository.findAll();
		return lista;
	}

	public Pagamento create(PagamentoDTO pagamentoDTO) {
		findById(pagamentoDTO.getId());
		return pagamentoRepository.save(mapper.map(pagamentoDTO, Pagamento.class));
	}

	public Optional<Pagamento> findById(long id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		return Optional.ofNullable(pagamento.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	public Pagamento update(PagamentoDTO pagamentoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
