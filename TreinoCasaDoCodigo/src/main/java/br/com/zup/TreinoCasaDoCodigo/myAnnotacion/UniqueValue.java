package br.com.zup.TreinoCasaDoCodigo.myAnnotacion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})//amarrando o unique value com a classe que ele vai fazer a validação
@Target({ElementType.FIELD})//Pode ser aplicada em atributos
@Retention(RetentionPolicy.RUNTIME)//tem que ser lida em runtime
public @interface UniqueValue {
	
	String message() default "{br.com.zup.treinoCasaDoCodigo}";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default {};
	
	String fielName();
	
	Class<?> domainClass();
}
