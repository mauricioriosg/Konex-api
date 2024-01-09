package com.test.cliente.domain.service;

import com.test.cliente.domain.DTO.response.ResponseDTO;
import com.test.cliente.domain.model.Client;
import com.test.cliente.domain.repository.IClientRepository;
import com.test.cliente.domain.service.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private IClientRepository clienteRepository;

    public ResponseDTO obtenerEmpleados(Integer currentPage, Integer perPage, String firstName, String otherNames,
                                        String surname, String secondSurname, Character identificationType, Long identificationNumber,
                                        Long localityID, Long dealerId) {
        ResponseDTO responseDTO;
        List<Client> clientList;

        try {
            clientList = clienteRepository.obtenerEmpleados(firstName, otherNames, surname, secondSurname,
                    identificationType, identificationNumber, localityID, dealerId);

            if (!clientList.isEmpty()) {
                perPage = perPage > 10 ? 10 : perPage;
                Integer startIndex = perPage * currentPage - perPage > clientList.size() ? clientList.size()
                        : perPage * currentPage - perPage;
                Integer endIndex = perPage * currentPage > clientList.size() ? clientList.size() : perPage * currentPage;
                clientList = clientList.subList(startIndex, endIndex);
                responseDTO = Utils.updateResponse(true, Optional.of(clientList), HttpStatus.OK.value(), currentPage,
                        perPage, "Consulta Exitosa.");
            } else {
                responseDTO = Utils.updateResponse(false, Optional.empty(), HttpStatus.NOT_FOUND.value(), 1, 1,
                        "No se encontraron registros.");
            }
        } catch (Exception e) {
            responseDTO = Utils.updateResponse(false, Optional.empty(), HttpStatus.INTERNAL_SERVER_ERROR.value(), 1, 1,
                    e.getMessage());
        }
        return responseDTO;
    }


    public ResponseDTO saveClient(Client client) {
        ResponseDTO responseDTO;
        Client clientR;
        try {

            boolean validClient = clienteRepository.valdiClientExist(
                    client.getIdentificationPK().getDocumentType(), client.getIdentificationPK().getDocument());

            if (validClient) {
                return responseDTO = Utils.updateResponse(false, Optional.empty(), HttpStatus.OK.value(), 1, 1,
                        "Ya existe un cliente con la identificacion ingresada.");
            }

            client.setRegistrationDate(LocalDateTime.now());
            client.setState(true);

            clientR = clienteRepository.saveClient(client);

            if (clientR != null) {
                responseDTO = Utils.updateResponse(true, Optional.of(clientR), HttpStatus.CREATED.value(), 1, 1,
                        "cliente Creado.");
            } else {
                responseDTO = Utils.updateResponse(false, Optional.empty(), HttpStatus.BAD_REQUEST.value(), 1, 1,
                        "No se guardo el cliente.");
            }
        } catch (Exception e) {
            responseDTO = Utils.updateResponse(false, Optional.empty(), HttpStatus.INTERNAL_SERVER_ERROR.value(), 1, 1,
                    e.getMessage());
        }
        return responseDTO;
    }

    public ResponseDTO updateClient(Client client) {
        ResponseDTO responseDTO;
        Client clientR;
        try {
            client.setModificationDate(LocalDateTime.now());

            clientR = clienteRepository.saveClient(client);

            if (clientR != null) {
                responseDTO = Utils.updateResponse(true, Optional.of(clientR), HttpStatus.OK.value(), 1, 1,
                        "cliente Actualizado.");
            } else {
                responseDTO = Utils.updateResponse(false, Optional.empty(), HttpStatus.BAD_REQUEST.value(), 1, 1,
                        "No se actualizo el cliente.");
            }
        } catch (Exception e) {
            responseDTO = Utils.updateResponse(false, Optional.empty(), HttpStatus.INTERNAL_SERVER_ERROR.value(), 1, 1,
                    e.getMessage());
        }
        return responseDTO;
    }

    public ResponseDTO deleteClient(Client client) {
        ResponseDTO responseDTO;
        Client clientR;
        try {
            client.setModificationDate(LocalDateTime.now());
            //borrado logico por estado
            client.setState(false);

            clientR = clienteRepository.saveClient(client);

            if (clientR != null) {
                responseDTO = Utils.updateResponse(true, Optional.of(clientR), HttpStatus.OK.value(), 1, 1,
                        "cliente Actualizado.");
            } else {
                responseDTO = Utils.updateResponse(false, Optional.empty(), HttpStatus.BAD_REQUEST.value(), 1, 1,
                        "No se actualizo el cliente.");
            }
        } catch (Exception e) {
            responseDTO = Utils.updateResponse(false, Optional.empty(), HttpStatus.INTERNAL_SERVER_ERROR.value(), 1, 1,
                    e.getMessage());
        }
        return responseDTO;
    }

}
