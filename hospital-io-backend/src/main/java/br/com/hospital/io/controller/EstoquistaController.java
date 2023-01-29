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
import br.com.hospital.io.model.Estoquista;
import br.com.hospital.io.model.dto.EstoquistaDTO;

import br.com.hospital.io.service.EstoquistaService;

@RestController
@RequestMapping(value = "/Estoquista/v1/api")
public class EstoquistaController {
	
	@Autowired
	private EstoquistaService estoquistaService;
	
	@Autowired
	private ModelMapper mapper; // BEAN CRIADO PARA INSTANCIAR O MAPPER 
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<List<EstoquistaDTO>> findAll(){
		List<Estoquista> list = estoquistaService.findAll();
		List<EstoquistaDTO> listDTO = list.stream().map(estoquista -> mapper.map(estoquista, EstoquistaDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<EstoquistaDTO>adicionar(@RequestBody EstoquistaDTO estoquistaDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estoquistaService.create(estoquistaDTO).getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<EstoquistaDTO>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(mapper.map(estoquistaService.findById(id), EstoquistaDTO.class));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody EstoquistaDTO estoquista){
	return ResponseEntity.status(HttpStatus.OK).body(estoquistaService.update(estoquista));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		estoquistaService.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
	
	
}
