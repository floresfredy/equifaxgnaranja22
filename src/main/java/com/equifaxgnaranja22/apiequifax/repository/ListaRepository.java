package com.equifaxgnaranja22.apiequifax.repository;

import java.util.List;

import com.equifaxgnaranja22.apiequifax.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<DatosConsulta, Integer>{

    @Query(value = "SELECT o FROM DatosConsulta o WHERE o.respuesta=?1")
    List<DatosConsulta> findItemsByRespuesta(Respuesta respuesta);
    
}
