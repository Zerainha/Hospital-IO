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
import br.com.hospital.io.model.Fornecedor;
import br.com.hospital.io.model.dto.FornecedorDTO;

import br.com.hospital.io.service.FornecedorService;

@RestController
@RequestMapping(value = "/Fornecedor/v1/api")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private ModelMapper mapper; // BEAN CRIADO PARA INSTANCIAR O MAPPER 
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<List<FornecedorDTO>> findAll(){
		List<Fornecedor> list = fornecedorService.findAll();
		List<FornecedorDTO> listDTO = list.stream().map(fornecedor -> mapper.map(fornecedor, FornecedorDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<FornecedorDTO>adicionar(@RequestBody FornecedorDTO fornecedorDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fornecedorService.create(fornecedorDTO).getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<FornecedorDTO>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(mapper.map(fornecedorService.findById(id), FornecedorDTO.class));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody FornecedorDTO fornecedor){
	return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.update(fornecedor));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		fornecedorService.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
	
	
}
