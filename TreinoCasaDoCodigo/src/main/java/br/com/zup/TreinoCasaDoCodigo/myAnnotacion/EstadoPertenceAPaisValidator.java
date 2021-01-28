package br.com.zup.TreinoCasaDoCodigo.myAnnotacion;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.TreinoCasaDoCodigo.controller.form.ComecoFluxoPagamentoForm;
import br.com.zup.TreinoCasaDoCodigo.model.Estado;
import br.com.zup.TreinoCasaDoCodigo.model.Pais;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ComecoFluxoPagamentoForm.class.isAssignableFrom(clazz);
	}
	
	@Deprecated
	public EstadoPertenceAPaisValidator() {}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		ComecoFluxoPagamentoForm request = (ComecoFluxoPagamentoForm) target;
		
		Pais pais = entityManager.find(Pais.class, request.getPais());
		Estado estado = entityManager.find(Estado.class, request.getEstado());
		if(!estado.pertenceAPais(pais)) {
			errors.reject("idEstado", null, "esse estado não é do país selecionado");
		}
	}
}
