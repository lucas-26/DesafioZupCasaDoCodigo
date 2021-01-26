package br.com.zup.TreinoCasaDoCodigo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.TreinoCasaDoCodigo.controller.dto.CategoriaDto;
import br.com.zup.TreinoCasaDoCodigo.controller.dto.ResponseCategoriaDto;
import br.com.zup.TreinoCasaDoCodigo.controller.form.CategoriaForm;
import br.com.zup.TreinoCasaDoCodigo.model.Categoria;
import br.com.zup.TreinoCasaDoCodigo.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/casaDoCodigo/Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping(value = "/CadastraCategoria")
	public ResponseEntity<ResponseCategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm) {
				
		try {
			
			Categoria categoria = new CategoriaForm().Converter(categoriaForm);
			categoriaRepository.save(categoria);
			
			Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(categoria.getId());
			CategoriaDto categoriaResposta = new CategoriaDto().converter(categoriaEncontrada);
			
			return ResponseEntity.ok().body(new ResponseCategoriaDto(categoriaResposta ,"Categoria Cadastrada com sucesso."));
					
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ResponseCategoriaDto("Não foi possivel cadastrar essa categoria"));
		}
	}
	
}
