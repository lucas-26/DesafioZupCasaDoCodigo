package br.com.zup.TreinoCasaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.TreinoCasaDoCodigo.controller.form.PaisForm;
import br.com.zup.TreinoCasaDoCodigo.model.Pais;
import br.com.zup.TreinoCasaDoCodigo.repository.PaisRepository;

@RestController
@RequestMapping("/casaDoCodigo/Pais")
public class PaisController {

	@Autowired
	PaisRepository paisRepository;
	
	@PostMapping("/cadastraPais")
	public ResponseEntity<?> cadastrarPais(@RequestBody @Valid PaisForm paisForm){
		try {
		
			Pais pais = paisForm.converter(paisForm); 
			paisRepository.save(pais);
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
