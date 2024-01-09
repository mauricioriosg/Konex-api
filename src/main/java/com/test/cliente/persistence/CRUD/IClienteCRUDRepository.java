package com.test.cliente.persistence.CRUD;

import com.test.cliente.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClienteCRUDRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT DISTINCT a FROM Cliente a WHERE a.identificacionPK.documento= :document and a.identificacionPK.tipoDocumento = :documentType")
    Cliente findAllByDocumentAndTypeDocument(@Param("documentType") Character documentType, @Param("document") Long document);

    @Query(value = "SELECT e from Cliente e "
            + "WHERE e.estado = true AND(e.primerNombre = :primerNombre OR '0' = :primerNombre) "
            + "AND (e.segundoNombre = :otrosNombres OR '0' = :otrosNombres) "
            + "AND (e.primerApellido = :primerApellido OR '0' = :primerApellido) "
            + "AND (e.segundoApellido = :segundoApellido OR '0' = :segundoApellido) "
            + "AND (e.identificacionPK.tipoDocumento = :tipoIdentificacion OR '0' = :tipoIdentificacion) "
            + "AND (e.identificacionPK.documento = :numeroIdentificacion OR 0 = :numeroIdentificacion) "
            + "AND (e.idLocalidad= :idLocalidad OR 0 = :idLocalidad) "
            + "AND (e.idConcesionario = :idConcesionario OR 0 = :idConcesionario) ")
    List<Cliente> getClienteByFilter(
            @Param("primerNombre") String primerNombre,
            @Param("otrosNombres") String otrosNombres,
            @Param("primerApellido") String primerApellido,
            @Param("segundoApellido") String segundoApellido,
            @Param("tipoIdentificacion") Character tipoIdentificacion,
            @Param("numeroIdentificacion") Long numeroIdentificacion,
            @Param("idLocalidad") Long localityID,
            @Param("idConcesionario") Long dealerId);
}
