package br.com.bluefisc.model.validators;
 
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.bluefisc.util.CNP;
 
public class ValidaCPFImp implements ConstraintValidator<ValidaCPF, String> {
 
    @Override
    public void initialize(ValidaCPF paramA) {
    	org.springframework.web.context.support.SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
 
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext ctx) {
    	if(cpf == null || cpf.isEmpty()){
    		return true;
    	}  
    	if (CNP.isValidCPF(cpf)){
    		return true; 
    	}
        return false;
    }      
}