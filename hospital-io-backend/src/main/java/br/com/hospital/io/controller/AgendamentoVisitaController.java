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
import br.com.hospital.io.model.AgendamentoVisita;
import br.com.hospital.io.model.dto.AgendamentoVisitaDTO;

import br.com.hospital.io.service.AgendamentoVisitaService;

@RestController
@RequestMapping(value = "/AgendamentoVisita/v1/api")
public class AgendamentoVisitaController {
	
	@Autowired
	private AgendamentoVisitaService agendamentoVisitaService;
	
	@Autowired
	private ModelMapper mapper; // BEAN CRIADO PARA INSTANCIAR O MAPPER 
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<List<AgendamentoVisitaDTO>> findAll(){
		List<AgendamentoVisita> list = agendamentoVisitaService.findAll();
		List<AgendamentoVisitaDTO> listDTO = list.stream().map(agendamentoVisita -> mapper.map(agendamentoVisita, AgendamentoVisitaDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<AgendamentoVisitaDTO>adicionar(@RequestBody AgendamentoVisitaDTO agendamentoVisitaDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agendamentoVisitaService.create(agendamentoVisitaDTO).getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<AgendamentoVisitaDTO>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(mapper.map(agendamentoVisitaService.findById(id), AgendamentoVisitaDTO.class));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody AgendamentoVisitaDTO agendamentoVisita){
	return ResponseEntity.status(HttpStatus.OK).body(agendamentoVisitaService.update(agendamentoVisita));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		agendamentoVisitaService.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
	
	
}
