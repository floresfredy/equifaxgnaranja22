package com.equifaxgnaranja22.apiequifax.repository;

import com.equifaxgnaranja22.apiequifax.model.AgregarDeudor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgregarDeudorRepository extends JpaRepository<AgregarDeudor, Integer> {
    
}