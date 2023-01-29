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
import br.com.hospital.io.model.AgendamentoConsulta;
import br.com.hospital.io.model.dto.AgendamentoConsultaDTO;

import br.com.hospital.io.service.AgendamentoConsultaService;

@RestController
@RequestMapping(value = "/AgendamentoConsulta/v1/api")
public class AgendamentoConsultaController {
	
	@Autowired
	private AgendamentoConsultaService agendamentoConsultaService;
	
	@Autowired
	private ModelMapper mapper; // BEAN CRIADO PARA INSTANCIAR O MAPPER 
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<List<AgendamentoConsultaDTO>> findAll(){
		List<AgendamentoConsulta> list = agendamentoConsultaService.findAll();
		List<AgendamentoConsultaDTO> listDTO = list.stream().map(agendamentoConsulta -> mapper.map(agendamentoConsulta, AgendamentoConsultaDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<AgendamentoConsultaDTO>adicionar(@RequestBody AgendamentoConsultaDTO agendamentoConsultaDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agendamentoConsultaService.create(agendamentoConsultaDTO).getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<AgendamentoConsultaDTO>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(mapper.map(agendamentoConsultaService.findById(id), AgendamentoConsultaDTO.class));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody AgendamentoConsultaDTO agendamentoConsulta){
	return ResponseEntity.status(HttpStatus.OK).body(agendamentoConsultaService.update(agendamentoConsulta));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		agendamentoConsultaService.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
	
	
}
