package br.com.zup.TreinoCasaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroForm livroForm) {
		try {
			Livro livroCadastro = LivroForm.converter(livroForm, entityManager);
			livroRepository.save(livroCadastro);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
