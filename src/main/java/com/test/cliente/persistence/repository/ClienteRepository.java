package com.test.cliente.persistence.repository;

import com.test.cliente.domain.model.Client;
import com.test.cliente.domain.repository.IClientRepository;
import com.test.cliente.persistence.CRUD.IClienteCRUDRepository;
import com.test.cliente.persistence.mapper.IClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository implements IClientRepository {

    @Autowired
    private IClienteMapper clienteMapper;

    @Autowired
    private IClienteCRUDRepository clienteCRUDRepository;

    @Override
    public List<Client> obtenerEmpleados(String firstName, String otherNames, String surname, String secondSurname, Character identificationType, Long identificationNumber, Long localityID, Long dealerId) {
        return clienteMapper.toClientList(clienteCRUDRepository.
                getClienteByFilter(firstName, otherNames, surname, secondSurname,
                        identificationType, identificationNumber, localityID, dealerId));
    }

    @Override
    public Client saveClient(Client client) {
        return clienteMapper.toClient(clienteCRUDRepository.save(clienteMapper.fromClient(client)));
    }

    @Override
    public void deleteClient(Long clientId) {

    }

    @Override
    public List<Client> findClients() {
        return null;
    }

    @Override
    public boolean valdiClientExist(Character documentType, Long document) {
        return clienteCRUDRepository.findAllByDocumentAndTypeDocument(documentType, document) != null ? true : false;
    }

}
