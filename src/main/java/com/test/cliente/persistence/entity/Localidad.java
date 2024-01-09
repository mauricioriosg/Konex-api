package com.test.cliente.persistence.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="localidad", schema = "actividades")
public class Localidad {

    @Id
    @Column(name = "codigo")
    private BigInteger codigo;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "ciudad")
    private String ciudad;
}
