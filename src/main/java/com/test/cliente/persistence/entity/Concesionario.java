package com.test.cliente.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "concesionario", schema = "actividades")
public class Concesionario {

    @Id
    @Column(name = "codigo")
    private BigInteger codigo;

    @Size(max = 20, message = "Excede la longitud permitida.")
    @Column(name = "nombre_concesionario", nullable = false)
    private String nombreConcesionario;

    @Size(max = 100, message = "Excede la longitud permitida.")
    @Column(name = "razon_social", nullable = false)
    private String razonSocial;

}
