package com.equifaxgnaranja22.apiequifax.repository;

import com.equifaxgnaranja22.apiequifax.model.Cliente;
import com.equifaxgnaranja22.apiequifax.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  ClienteRepository extends JpaRepository<Cliente, Integer>{


    @Query(value = "SELECT o FROM Cliente o WHERE o.user=?1")
    Cliente findByUsuario(Usuario user);
    
}