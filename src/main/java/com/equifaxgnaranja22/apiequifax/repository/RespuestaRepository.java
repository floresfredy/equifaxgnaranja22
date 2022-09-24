package com.equifaxgnaranja22.apiequifax.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;
import com.equifaxgnaranja22.apiequifax.model.*;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer>{
    @Query(value = "SELECT o FROM Respuesta o WHERE o.dni=?1")
    Optional<Respuesta> findByNumero(String dni);
    
}
