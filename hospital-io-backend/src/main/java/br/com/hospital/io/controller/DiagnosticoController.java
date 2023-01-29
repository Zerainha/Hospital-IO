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
import br.com.hospital.io.model.Diagnostico;
import br.com.hospital.io.model.dto.DiagnosticoDTO;

import br.com.hospital.io.service.DiagnosticoService;

@RestController
@RequestMapping(value = "/Diagnostico/v1/api")
public class DiagnosticoController {
	
	@Autowired
	private DiagnosticoService diagnosticoService;
	
	@Autowired
	private ModelMapper mapper; // BEAN CRIADO PARA INSTANCIAR O MAPPER 
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<List<DiagnosticoDTO>> findAll(){
		List<Diagnostico> list = diagnosticoService.findAll();
		List<DiagnosticoDTO> listDTO = list.stream().map(diagnostico -> mapper.map(diagnostico, DiagnosticoDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<DiagnosticoDTO>adicionar(@RequestBody DiagnosticoDTO diagnosticoDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(diagnosticoService.create(diagnosticoDTO).getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<DiagnosticoDTO>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(mapper.map(diagnosticoService.findById(id), DiagnosticoDTO.class));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody DiagnosticoDTO diagnostico){
	return ResponseEntity.status(HttpStatus.OK).body(diagnosticoService.update(diagnostico));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		diagnosticoService.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
	
	
}
