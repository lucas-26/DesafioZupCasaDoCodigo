package br.com.zup.TreinoCasaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.TreinoCasaDoCodigo.controller.form.EstadoForm;
import br.com.zup.TreinoCasaDoCodigo.model.Estado;
import br.com.zup.TreinoCasaDoCodigo.repository.EstadoRepository;

@RestController
@RequestMapping("/casaDoCodigo/Estado")
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	EntityManager entityManager;

	@PostMapping("/CadastrarEstado")
	public ResponseEntity<?> CadastrarEstado(@RequestBody @Valid EstadoForm estadoForm) {
		Estado estado = EstadoForm.converter(estadoForm, entityManager);
		estadoRepository.save(estado);
		return ResponseEntity.ok().build();
	}
}
