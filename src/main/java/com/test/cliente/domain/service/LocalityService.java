package com.test.cliente.domain.service;

import com.test.cliente.domain.DTO.response.ResponseDTO;
import com.test.cliente.domain.model.Locality;
import com.test.cliente.domain.repository.ILocalityRepository;
import com.test.cliente.domain.service.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalityService {

    @Autowired
    private ILocalityRepository localityRepository;

    public ResponseDTO getLocalities() {
        ResponseDTO responseDTO;
        List<Locality> localities;

        try {
            localities = localityRepository.getLocality();

            if (!localities.isEmpty()) {
                responseDTO = Utils.updateResponse(true, Optional.of(localities),
                        HttpStatus.OK.value(), 1, 1, "Consulta Exitosa.");
            } else {
                responseDTO = Utils.updateResponse(false, Optional.empty(),
                        HttpStatus.NOT_FOUND.value(), 1, 1, "No se encontraron registros.");
            }
        } catch (Exception e) {
            responseDTO = Utils.updateResponse(false, Optional.empty(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), 1, 1, e.getMessage());
        }
        return responseDTO;
    }
}
