package com.equifaxgnaranja22.apiequifax.integracion.reniec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReniecAPI {
    
    @Autowired
    private RestTemplate restTemplate;


    public ReniecUSER findExitsUserByDni(String dni){

        ReniecUSER reniec = null;

        try {

           reniec = restTemplate.getForObject("https://app-reniec.herokuapp.com/api/persona/{dni}", ReniecUSER.class, dni);

        } catch (Exception e) {
            
            System.out.println("No existe el usuario");
        }
      

        return reniec;

    }
}