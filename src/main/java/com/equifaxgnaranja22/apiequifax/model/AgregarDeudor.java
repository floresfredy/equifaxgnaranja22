package com.equifaxgnaranja22.apiequifax.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "t_respuesta")
public class AgregarDeudor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String apellidos;
    private String nombres;
    private String dni;
    private String nacionalidad;
    private String ocupacion;
}