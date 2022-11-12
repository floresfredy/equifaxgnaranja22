package com.equifaxgnaranja22.apiequifax.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.equifaxgnaranja22.apiequifax.model.DatosConsulta;

import com.equifaxgnaranja22.apiequifax.repository.DatosConsultaRepository;
import com.equifaxgnaranja22.apiequifax.repository.UsuarioRepository;
import javax.validation.Valid;

@Controller
public class datosConsultaController {
    
    

    private static final String INDEX ="dashboard/datosconsulta"; 
    private static String MODEL_CONTACT="deuda";
    private final DatosConsultaRepository deudaData;

    public datosConsultaController(DatosConsultaRepository deudaData,
        UsuarioRepository usuariosData    
        ){
        this.deudaData = deudaData;
    }      

    @GetMapping("/dashboard/datosconsulta")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new DatosConsulta());
        return INDEX;
    }    

    @PostMapping("/dashboard/datosconsulta")
    public String createSubmitForm(Model model, 
        @Valid DatosConsulta objDeuda, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute(MODEL_CONTACT, objDeuda);
            model.addAttribute("mensajed", "algo falló");
            
        }else{
            this.deudaData.save(objDeuda);
            model.addAttribute(MODEL_CONTACT, objDeuda);
            model.addAttribute("mensajed", "Se registro deuda");
        }
        return INDEX;
    }

}