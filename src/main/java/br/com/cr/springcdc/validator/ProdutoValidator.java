package br.com.cr.springcdc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.cr.springcdc.model.Produto;

public class ProdutoValidator implements Validator {
	
	/* informa classe que deve ser validada ao realizar o binding */
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Produto.class.isAssignableFrom(clazz);
	}
	
	/* informa quais campos e como deverá realizar a validacao */
	@Override
	public void validate(Object target, Errors errors) {
		Produto produto = (Produto) target;
		
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		
		if(produto.getPaginas() <= 0) {
			errors.rejectValue("paginas", "field.required");
		}
		
	}

}
