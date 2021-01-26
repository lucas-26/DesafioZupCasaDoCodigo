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
import br.com.zup.TreinoCasaDoCodigo.controller.dto.ResponseAutorDto;
import br.com.zup.TreinoCasaDoCodigo.controller.form.AutorForm;
import br.com.zup.TreinoCasaDoCodigo.model.Autor;
import br.com.zup.TreinoCasaDoCodigo.repository.AutorRepository;

@RestController
@RequestMapping(value = "/casaDoCodigo/Autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepositoty;

	@PostMapping(value = "/CadastrarAutor")
	public ResponseEntity<ResponseAutorDto> cadastrarAutor(@RequestBody @Valid AutorForm autorForm) {
		
		try {
			Autor autor = autorForm.converter(autorForm);
			autorRepositoty.save(autor);
			
			Optional<Autor> autorEncontrado = autorRepositoty.findByemail(autorForm.getEmail());
			AutorDto ResponseAuto = new AutorDto(autorEncontrado.get().getNome(), autorEncontrado.get().getEmail(), autorEncontrado.get().getDescricao());
			return ResponseEntity.ok().body(new ResponseAutorDto(ResponseAuto ,"Autor cadastrado com sucesso."));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ResponseAutorDto("Esse autor não pode ser cadastrado."));
		}
	}

	@GetMapping(value = "buscaAutor/{id}")
	public ResponseEntity<AutorDto> buscarAutor(@PathVariable Long id) {
		Optional<Autor> autorEncontrado = autorRepositoty.findById(id);

		if (autorEncontrado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new AutorDto(autorEncontrado.get().getNome(), autorEncontrado.get().getEmail(),
				autorEncontrado.get().getDescricao()));
	}

}