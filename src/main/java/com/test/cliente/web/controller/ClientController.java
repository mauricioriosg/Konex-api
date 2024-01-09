package com.test.cliente.web.controller;

import com.test.cliente.domain.DTO.response.ResponseDTO;
import com.test.cliente.domain.model.Client;
import com.test.cliente.domain.service.ClientService;
import com.test.cliente.domain.service.utils.Utils;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
@Api(value = "Controlador que contiene los métodos del API relacionados con los clientes")
@ApiResponses(value = {@ApiResponse(code = 200, message = "Respuesta exitosa."),
        @ApiResponse(code = 400, message = "Petición incorrecta."),
        @ApiResponse(code = 404, message = "No se encontraron datos."),
        @ApiResponse(code = 500, message = "Error del servidor.")})
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;

    @ApiOperation(value = "Consulta los clientes", notes = "Permite consultar los clientes")
    @GetMapping(value = "/getClients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getClients(
            @ApiParam(value = "Página actual del paginador.", required = true)
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @ApiParam(value = "Registros por página del paginador.", required = true)
            @RequestParam(value = "perPage", defaultValue = "10") Integer perPage,
            @ApiParam(value = "Primer nombre que se usara para filtrar la consulta.", required = false)
            @RequestParam(value = "firstName",  defaultValue = "0") String firstName,
            @ApiParam(value = "Segundo nombre que se usara para filtrar la consulta.", required = false)
            @RequestParam(value = "otherNames", defaultValue = "0") String otherNames,
            @ApiParam(value = "Primer apellido que se usara para filtrar la consulta.", required = false)
            @RequestParam(value = "surname",  defaultValue = "0") String surname,
            @ApiParam(value = "Segundo apellido que se usara para filtrar la consulta.", required = false)
            @RequestParam(value = "secondSurname", defaultValue = "0") String secondSurname,
            @ApiParam(value = "Tipo Identificacion que se usara para filtrar la consulta.", required = false)
            @RequestParam(value = "identificationType", defaultValue = "0") Character identificationType,
            @ApiParam(value = "Numero Identificacion que se usara para filtrar la consulta.", required = false)
            @RequestParam(value = "identificationNumber", defaultValue = "0") Long identificationNumber,
            @ApiParam(value = "localidad que se usara para filtrar la consulta.", required = false)
            @RequestParam(value = "localityID", defaultValue = "0") Long localityID,
            @ApiParam(value = "concesionario que se usara para filtrar la consulta.", required = false)
            @RequestParam(value = "dealerId", defaultValue = "0") Long dealerId) {

        ResponseDTO response;
        try {
            response = clientService.obtenerEmpleados(currentPage, perPage,
                    firstName, otherNames, surname, secondSurname, identificationType,
                    identificationNumber, localityID, dealerId);

            if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception ex) {
            response = Utils.errorResponse(LOGGER, ex);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }


    @ApiOperation(value = "Crear cliente", notes = "Permite crear el cliente")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody Client client) {

        ResponseDTO response;
        try {
            response = clientService.saveClient(client);

            if (response.getStatus() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            } else if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            } else if (response.getStatus() == HttpStatus.OK.value()) {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception ex) {
            response = Utils.errorResponse(LOGGER, ex);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }

    @ApiOperation(value = "Actualizar cliente", notes = "Permite actualizar el cliente")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEmployee(
            @Valid @RequestBody Client client) {

        ResponseDTO response;
        try {
            response = clientService.updateClient(client);

            if (response.getStatus() == HttpStatus.BAD_REQUEST.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            } else if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            } else if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception ex) {
            response = Utils.errorResponse(LOGGER, ex);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }

    @ApiOperation(value = "Eliminar cliente", notes = "Permite eliminar el cliente")
    @PutMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteEmployee(
            @Valid @RequestBody Client client) {

        ResponseDTO response;
        try {
            response = clientService.deleteClient(client);

            if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception ex) {
            response = Utils.errorResponse(LOGGER, ex);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }
}
