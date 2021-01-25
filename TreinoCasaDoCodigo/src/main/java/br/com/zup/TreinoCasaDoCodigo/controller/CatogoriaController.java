package br.com.zup.TreinoCasaDoCodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.TreinoCasaDoCodigo.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/casaDoCodigo/Categoria")
public class CatogoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
}
