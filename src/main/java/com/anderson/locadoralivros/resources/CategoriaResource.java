package com.anderson.locadoralivros.resources; // Pacote responsável por receber as requisições do frontend para o end point

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anderson.locadoralivros.domain.Categoria;
import com.anderson.locadoralivros.dtos.CategoriaDto;
import com.anderson.locadoralivros.sevice.CategoriaService;

@RestController
@RequestMapping(value = "/categorias") // método que recebe a requisição de acesso ao endpoint coletando seu id pelo caminho
public class CategoriaResource {       // localhost:8080/categorias/1

	//Implementando a instância contida na classe CateforiaService
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")//Anotação que retorna o mapeamento do tipo get com o caminho do endpoint solicitado anteriormente /categorias/1 -> valor do Id
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){ //do método solicitado abaixo chamado responseEntity<Categoria>.
		Categoria obj = service.findById(id); // objeto que recebe a instancia CategoriaService service importada e apontada para o método findById com o parâmetro id criado na classe CategoriaService.
		return ResponseEntity.ok().body(obj);
	}
	
	//Método responsável por converter a lista de categorias em lista de categoria para o tipo dto, onde os objetos serão filtrados para o usuário não obter um response com dados a mais do que é necessário para sua consulta
	
	@GetMapping
	public ResponseEntity<List<CategoriaDto>> findall(){
		List<Categoria> list = service.findAll();
		List<CategoriaDto> listDto = list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
