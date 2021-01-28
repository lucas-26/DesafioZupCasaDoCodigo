package br.com.zup.TreinoCasaDoCodigo.myAnnotacion;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.TreinoCasaDoCodigo.controller.form.ComecoFluxoPagamentoForm;
import br.com.zup.TreinoCasaDoCodigo.model.ComecoFluxoPagamento;

public class verificaDocumento implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ComecoFluxoPagamentoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			
		}
		ComecoFluxoPagamentoForm request = (ComecoFluxoPagamentoForm) target;
		if (!request.documentoValido()) {
			errors.rejectValue("documento", null, "Documento precisa ser cpf ou cnpj");
		}
	}

}
