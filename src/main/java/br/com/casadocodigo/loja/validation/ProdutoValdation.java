package br.com.casadocodigo.loja.validation;

import br.com.casadocodigo.loja.models.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProdutoValdation implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Produto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object traget, Errors errors) {
            ValidationUtils.rejectIfEmpty(errors,"titulo","field.required");
            ValidationUtils.rejectIfEmpty(errors,"descricao","field.required");
            Produto produto = (Produto) traget;
            if(produto.getPaginas() <= 0){{
                errors.rejectValue("paginas","field.required");
            }}
            ValidationUtils.rejectIfEmpty(errors,"paginas","field.required");

    }
}
