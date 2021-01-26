package br.com.zup.TreinoCasaDoCodigo.controller;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.TreinoCasaDoCodigo.controller.dto.LivroDto;
import br.com.zup.TreinoCasaDoCodigo.controller.form.LivroForm;
import br.com.zup.TreinoCasaDoCodigo.model.Livro;
import br.com.zup.TreinoCasaDoCodigo.repository.LivroRepository;

@RestController
@RequestMapping("/casaDoCodigo/Livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping("/CadastrarLivros")
	public ResponseEntity<LivroDto> cadastrarLivro(@RequestBody @Valid LivroForm livroForm) {
		try {
			Livro livroCadastro = LivroForm.converter(livroForm, entityManager);
			livroRepository.save(livroCadastro);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		} 
	}
	
	@GetMapping("/ListaLivro/{id}")
	public ResponseEntity<LivroDto> buscaLivroPorId(@PathVariable long id){
		Optional<Livro> livro = livroRepository.findById(id);
		LivroDto livroDto = new LivroDto().converter(livro, entityManager);
		return ResponseEntity.ok().body(livroDto);
	}
}
