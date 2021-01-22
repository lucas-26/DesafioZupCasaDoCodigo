package br.com.zup.TreinoCasaDoCodigo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.TreinoCasaDoCodigo.controller.dto.AutorDto;
import br.com.zup.TreinoCasaDoCodigo.controller.form.AutorForm;
import br.com.zup.TreinoCasaDoCodigo.model.Autor;
import br.com.zup.TreinoCasaDoCodigo.repository.AutorRepository;

@RestController
@RequestMapping(value = "/casaDoCodigo")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepositoty;
	
	@PostMapping(value = "/cadastrarAutor")
	public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder){
		Autor autor = autorForm.converter(autorForm);
		autorRepositoty.save(autor);
		Optional<Autor> autorEncontrado = autorRepositoty.findById(autor.getId()); 
		return ResponseEntity.ok(new AutorDto(autorEncontrado.get().getNome(), autorEncontrado.get().getEmail(), autorEncontrado.get().getDescricao()));
	}
	
	@GetMapping(value = "buscaAutor/{id}")
	public ResponseEntity<AutorDto> buscarAutor(@PathVariable Long id){
		Optional<Autor> autorEncontrado = autorRepositoty.findById(id);
		
		if(autorEncontrado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.ok(new AutorDto(autorEncontrado.get().getNome(), autorEncontrado.get().getEmail(), autorEncontrado.get().getDescricao()));
	}

}
