package com.test.cliente.web.controller;

import com.test.cliente.domain.DTO.response.ResponseDTO;
import com.test.cliente.domain.service.LocalityService;
import com.test.cliente.domain.service.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/locality")
@Api(value = "Controlador que contiene los métodos del API relacionados con los localidades")
@ApiResponses(value = {@ApiResponse(code = 200, message = "Respuesta exitosa."),
        @ApiResponse(code = 400, message = "Petición incorrecta."),
        @ApiResponse(code = 404, message = "No se encontraron datos."),
        @ApiResponse(code = 500, message = "Error del servidor.")})
public class LocalityController {

    @Autowired
    LocalityService localityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalityController.class);

    @ApiOperation(value = "Consulta las localidades", notes = "Permite consultar las localidades")
    @GetMapping(value = "/getLocalities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLocalities() {

        ResponseDTO response;
        try {
            response = localityService.getLocalities();

            if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

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
