package br.com.zup.TreinoCasaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.TreinoCasaDoCodigo.controller.form.ComecoFluxoPagamentoForm;
import br.com.zup.TreinoCasaDoCodigo.model.ComecoFluxoPagamento;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.EstadoPertenceAPaisValidator;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.verificaDocumento;

@RestController
@RequestMapping(value = "/casaDoCodigo/pagamento")
public class ComecoFluxoPagamentoController {

	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new verificaDocumento(), estadoPertenceAPaisValidator);
	}

	@PostMapping("novoPagamento")
	public ResponseEntity<?> NovoPagamento(@RequestBody @Valid ComecoFluxoPagamentoForm comecoPagamento) {
		ComecoFluxoPagamento pagamento = ComecoFluxoPagamentoForm.converter(comecoPagamento);
		return ResponseEntity.ok().body(pagamento);
	}
}
