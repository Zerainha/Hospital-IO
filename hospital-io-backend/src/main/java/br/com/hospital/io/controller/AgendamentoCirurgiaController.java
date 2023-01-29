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
import br.com.hospital.io.model.AgendamentoCirurgia;
import br.com.hospital.io.model.dto.AgendamentoCirurgiaDTO;

import br.com.hospital.io.service.AgendamentoCirurgiaService;

@RestController
@RequestMapping(value = "/AgendamentoCirurgia/v1/api")
public class AgendamentoCirurgiaController {
	
	@Autowired
	private AgendamentoCirurgiaService agendamentoCirurgiaService;
	
	@Autowired
	private ModelMapper mapper; // BEAN CRIADO PARA INSTANCIAR O MAPPER 
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<List<AgendamentoCirurgiaDTO>> findAll(){
		List<AgendamentoCirurgia> list = agendamentoCirurgiaService.findAll();
		List<AgendamentoCirurgiaDTO> listDTO = list.stream().map(agendamentoCirurgia -> mapper.map(agendamentoCirurgia, AgendamentoCirurgiaDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<AgendamentoCirurgiaDTO>adicionar(@RequestBody AgendamentoCirurgiaDTO agendamentoCirurgiaDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agendamentoCirurgiaService.create(agendamentoCirurgiaDTO).getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<AgendamentoCirurgiaDTO>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(mapper.map(agendamentoCirurgiaService.findById(id), AgendamentoCirurgiaDTO.class));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody AgendamentoCirurgiaDTO agendamentoCirurgia){
	return ResponseEntity.status(HttpStatus.OK).body(agendamentoCirurgiaService.update(agendamentoCirurgia));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		agendamentoCirurgiaService.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
	
	
}
