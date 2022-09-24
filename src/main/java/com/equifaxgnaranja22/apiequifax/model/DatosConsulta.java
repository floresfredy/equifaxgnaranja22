package com.equifaxgnaranja22.apiequifax.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_datoConsulta")

public class DatosConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal deuda;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha; 
    private Integer diasVencidas;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "respuesta_id")    
    private Respuesta respuesta;
    
}
