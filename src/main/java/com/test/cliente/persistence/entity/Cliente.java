package com.test.cliente.persistence.entity;

import com.test.cliente.persistence.entity.compositeKey.IdentificacionPK;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "cliente", schema = "actividades")
public class Cliente {

    @EmbeddedId
    private IdentificacionPK identificacionPK;

    @Size(max = 20, message = "Excede la longitud permitida.")
    @Column(name = "primer_apellido")
    private String primerApellido;

    @Size(max = 20, message = "Excede la longitud permitida.")
    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Size(max = 20, message = "Excede la longitud permitida.")
    @Column(name = "primer_nombre")
    private String primerNombre;

    @Size(max = 20, message = "Excede la longitud permitida.")
    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "id_localidad")
    private Long idLocalidad;

    @Column(name = "id_concesionario")
    private Long idConcesionario;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name="fecha_modificacion")
    private LocalDateTime fechaModificacion;

}
