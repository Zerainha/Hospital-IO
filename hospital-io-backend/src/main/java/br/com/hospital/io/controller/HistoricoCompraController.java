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

import br.com.hospital.io.model.HistoricoCompra;
import br.com.hospital.io.model.dto.HistoricoCompraDTO;
import br.com.hospital.io.service.HistoricoService;

@RestController
@RequestMapping(value = "/Historico/v1/api")
public class HistoricoCompraController {
	
	@Autowired
	private HistoricoService historicoService;
	
	@Autowired
	private ModelMapper mapper; // BEAN CRIADO PARA INSTANCIAR O MAPPER 
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<List<HistoricoCompraDTO>> findAll(){
		List<HistoricoCompra> list = historicoService.findAll();
		List<HistoricoCompraDTO> listDTO = list.stream().map(historico -> mapper.map(historico, HistoricoCompraDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<HistoricoCompraDTO>adicionar(@RequestBody HistoricoCompraDTO historicoDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(historicoService.create(historicoDTO).getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<HistoricoCompraDTO>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(mapper.map(historicoService.findById(id), HistoricoCompraDTO.class));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody HistoricoCompraDTO historico){
	return ResponseEntity.status(HttpStatus.OK).body(historicoService.update(historico));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		historicoService.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
	
	
}
