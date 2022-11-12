package com.equifaxgnaranja22.apiequifax.integracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.equifaxgnaranja22.apiequifax.integracion.reniec.ReniecAPI;
import com.equifaxgnaranja22.apiequifax.model.AgregarDeudor;

@Component
public class ExisteUsuario implements Validator {
    
    

    @Autowired
    private ReniecAPI reniecAPI;

    @Override
    public boolean supports(Class<?> clazz) {
       
        return AgregarDeudor.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      
        AgregarDeudor usuario = (AgregarDeudor) target;

        if(usuario.getDni().length() > 0){

            if(reniecAPI.findExitsUserByDni(usuario.getDni()) == null){

                errors.rejectValue("dni", "invalidate.identificador");

            }
        }
          
    }
    
}
