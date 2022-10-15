package com.equifaxgnaranja22.apiequifax.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.equifaxgnaranja22.apiequifax.model.AgregarDeudor;

import com.equifaxgnaranja22.apiequifax.repository.AgregarDeudorRepository;
import com.equifaxgnaranja22.apiequifax.repository.UsuarioRepository;
import com.equifaxgnaranja22.apiequifax.integracion.ExisteUsuario;
import javax.validation.Valid;

@Controller
public class AgregarDeudorController {
    
    @Autowired
    private ExisteUsuario validando;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(validando);
    }

    private static final String INDEX ="dashboard/agregardeudor"; 
    private static String MODEL_CONTACT="deudor";
    private final AgregarDeudorRepository deudorData;

    public AgregarDeudorController(AgregarDeudorRepository deudorData,
        UsuarioRepository usuariosData    
        ){
        this.deudorData = deudorData;
    }      

    @GetMapping("/dashboard/agregardeudor")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new AgregarDeudor());
        return INDEX;
    }    

    @PostMapping("/dashboard/agregardeudor")
    public String createSubmitForm(Model model, 
        @Valid AgregarDeudor objDeudor, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro el deudor");
        }else{
            
            
            this.deudorData.save(objDeudor);
            model.addAttribute(MODEL_CONTACT, objDeudor);
            model.addAttribute("mensaje", "Se registro el deudor");
        }
        return INDEX;
    }

}