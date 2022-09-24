package com.equifaxgnaranja22.apiequifax.repository;

import com.equifaxgnaranja22.apiequifax.model.Contacto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
    
}
