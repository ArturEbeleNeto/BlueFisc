package br.com.bluefisc.model.validators;
 
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
 
import javax.validation.Constraint;
import javax.validation.Payload;
 
@Documented
@Constraint(validatedBy = ValidaCPFImp.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaCPF {
      
    String message() default "CPF Inválido";
      
    Class<?>[] groups() default {};
      
    Class<? extends Payload>[] payload() default {};
       
}