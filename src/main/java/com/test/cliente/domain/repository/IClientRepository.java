package com.test.cliente.domain.repository;

import com.test.cliente.domain.model.Client;

import java.util.List;

public interface IClientRepository {

    List<Client> obtenerEmpleados(String firstName, String otherNames,
                                  String surname, String secondSurname, Character identificationType, Long identificationNumber,
                                  Long localityID, Long dealerId);

    Client saveClient(Client client);

    void deleteClient(Long clientId);

    List<Client> findClients();

    boolean valdiClientExist(Character documentType, Long document);
}
