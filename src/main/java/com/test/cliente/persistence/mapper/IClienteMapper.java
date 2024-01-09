package com.test.cliente.persistence.mapper;

import com.test.cliente.domain.model.Client;
import com.test.cliente.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapper {

    @Mappings({
            @Mapping(source = "identificacionPK.tipoDocumento", target = "identificationPK.documentType"),
            @Mapping(source = "identificacionPK.documento", target = "identificationPK.document"),
            @Mapping(source = "primerApellido", target = "firstSurname"),
            @Mapping(source = "segundoApellido", target = "secondSurname"),
            @Mapping(source = "primerNombre", target = "firstName"),
            @Mapping(source = "segundoNombre", target = "secondName"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "idLocalidad", target = "localityID"),
            @Mapping(source = "idConcesionario", target = "dealerId"),
            @Mapping(source = "fechaRegistro", target = "registrationDate"),
            @Mapping(source = "fechaModificacion", target = "modificationDate"),
    })
    Client toClient(Cliente cliente);

    List<Client> toClientList(List<Cliente> clienteList);

    @InheritInverseConfiguration
    Cliente fromClient(Client client);

    List<Cliente> fromClientList(List<Client> clientList);
}
