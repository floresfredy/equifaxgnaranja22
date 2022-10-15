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

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}