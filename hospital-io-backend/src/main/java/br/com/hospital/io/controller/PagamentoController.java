package br.com.hospital.io.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.hospital.io.model.Pagamento;
import br.com.hospital.io.model.dto.PagamentoDTO;

import br.com.hospital.io.service.PagamentoService;

@RestController
@RequestMapping(value = "/Pagamento/v1/api")
public class PagamentoController {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired
	private ModelMapper mapper; // BEAN CRIADO PARA INSTANCIAR O MAPPER 
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<List<PagamentoDTO>> findAll(){
		List<Pagamento> list = pagamentoService.findAll();
		List<PagamentoDTO> listDTO = list.stream().map(pagamento -> mapper.map(pagamento, PagamentoDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<PagamentoDTO>adicionar(@RequestBody PagamentoDTO pagamentoDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pagamentoService.create(pagamentoDTO).getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<PagamentoDTO>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(mapper.map(pagamentoService.findById(id), PagamentoDTO.class));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody PagamentoDTO pagamento){
	return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.update(pagamento));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		pagamentoService.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
	
	
}
