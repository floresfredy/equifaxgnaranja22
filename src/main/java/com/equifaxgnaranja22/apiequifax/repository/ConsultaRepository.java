package com.equifaxgnaranja22.apiequifax.repository;


import com.equifaxgnaranja22.apiequifax.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

import java.util.*;


@Repository
public interface ConsultaRepository extends JpaRepository<DatosConsulta, Integer> {
    @Query(value = "SELECT o FROM DatosConsulta o WHERE o.respuesta=?1")
    List<DatosConsulta> findItemsByRespuesta(Respuesta respuesta);

    @Query(value = "SELECT rs.nombres as nombre, SUM(o.deuda) as deudaTotal FROM DatosConsulta o JOIN o.respuesta rs GROUP BY rs.nombres ORDER BY deudaTotal DESC")
    List<Map<String, Object>> querySumaTotal();

    @Query(value = "SELECT rs.nombres as nombre, SUM(o.diasVencidas) as diasTotalVencidas FROM DatosConsulta o JOIN o.respuesta rs GROUP BY rs.nombres ORDER BY diasTotalVencidas DESC")
    List<Map<String, Object>> querySumaTotalDias();
}
