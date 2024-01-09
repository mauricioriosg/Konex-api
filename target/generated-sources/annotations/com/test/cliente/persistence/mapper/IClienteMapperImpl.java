package com.test.cliente.persistence.mapper;

import com.test.cliente.domain.model.Client;
import com.test.cliente.domain.model.compositeKey.IdentificationPK;
import com.test.cliente.persistence.entity.Cliente;
import com.test.cliente.persistence.entity.compositeKey.IdentificacionPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-09T03:01:42-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
@Component
public class IClienteMapperImpl implements IClienteMapper {

    @Override
    public Client toClient(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Client client = new Client();

        client.setIdentificationPK( identificacionPKToIdentificationPK( cliente.getIdentificacionPK() ) );
        client.setFirstSurname( cliente.getPrimerApellido() );
        client.setSecondSurname( cliente.getSegundoApellido() );
        client.setFirstName( cliente.getPrimerNombre() );
        client.setSecondName( cliente.getSegundoNombre() );
        client.setState( cliente.getEstado() );
        client.setLocalityID( cliente.getIdLocalidad() );
        client.setDealerId( cliente.getIdConcesionario() );
        client.setRegistrationDate( cliente.getFechaRegistro() );
        client.setModificationDate( cliente.getFechaModificacion() );

        return client;
    }

    @Override
    public List<Client> toClientList(List<Cliente> clienteList) {
        if ( clienteList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( clienteList.size() );
        for ( Cliente cliente : clienteList ) {
            list.add( toClient( cliente ) );
        }

        return list;
    }

    @Override
    public Cliente fromClient(Client client) {
        if ( client == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setIdentificacionPK( identificationPKToIdentificacionPK( client.getIdentificationPK() ) );
        cliente.setPrimerApellido( client.getFirstSurname() );
        cliente.setSegundoApellido( client.getSecondSurname() );
        cliente.setPrimerNombre( client.getFirstName() );
        cliente.setSegundoNombre( client.getSecondName() );
        cliente.setEstado( client.getState() );
        cliente.setIdLocalidad( client.getLocalityID() );
        cliente.setIdConcesionario( client.getDealerId() );
        cliente.setFechaRegistro( client.getRegistrationDate() );
        cliente.setFechaModificacion( client.getModificationDate() );

        return cliente;
    }

    @Override
    public List<Cliente> fromClientList(List<Client> clientList) {
        if ( clientList == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( clientList.size() );
        for ( Client client : clientList ) {
            list.add( fromClient( client ) );
        }

        return list;
    }

    protected IdentificationPK identificacionPKToIdentificationPK(IdentificacionPK identificacionPK) {
        if ( identificacionPK == null ) {
            return null;
        }

        IdentificationPK identificationPK = new IdentificationPK();

        identificationPK.setDocumentType( identificacionPK.getTipoDocumento() );
        identificationPK.setDocument( identificacionPK.getDocumento() );

        return identificationPK;
    }

    protected IdentificacionPK identificationPKToIdentificacionPK(IdentificationPK identificationPK) {
        if ( identificationPK == null ) {
            return null;
        }

        IdentificacionPK identificacionPK = new IdentificacionPK();

        identificacionPK.setTipoDocumento( identificationPK.getDocumentType() );
        identificacionPK.setDocumento( identificationPK.getDocument() );

        return identificacionPK;
    }
}
