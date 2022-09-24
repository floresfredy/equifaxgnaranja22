package com.equifaxgnaranja22.apiequifax.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.equifaxgnaranja22.apiequifax.model.Cliente;
import com.equifaxgnaranja22.apiequifax.model.Usuario;
import com.equifaxgnaranja22.apiequifax.repository.ClienteRepository;
import com.equifaxgnaranja22.apiequifax.repository.UsuarioRepository;

import javax.validation.Valid;

@Controller
public class ClienteController {
    
    private static final String INDEX ="cliente/crear"; 
    private static String MODEL_CONTACT="client";
    private final ClienteRepository clientsData;
    private final UsuarioRepository usuariosData;

    public ClienteController(ClienteRepository clientsData,
        UsuarioRepository usuariosData    
        ){
        this.clientsData = clientsData;
        this.usuariosData = usuariosData;
    }      

    @GetMapping("/cliente/crear")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new Cliente());
        return INDEX;
    }    

    @PostMapping("/cliente/crear")
    public String createSubmitForm(Model model, 
        @Valid Cliente objCliente, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro el cliente");
        }else{
            Usuario user = objCliente.getUser();
            user.setTipoUsuario("C");
            this.usuariosData.save(user);
            this.usuariosData.flush();
            this.clientsData.save(objCliente);
            model.addAttribute(MODEL_CONTACT, objCliente);
            model.addAttribute("mensaje", "Se registro el cliente");
        }
        return INDEX;
    }

}