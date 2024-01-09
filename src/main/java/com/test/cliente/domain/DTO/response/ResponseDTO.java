package com.test.cliente.domain.DTO.response;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    private Boolean ok;
    private String message;
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<?> data;
    private Integer status;
    private Integer currentPage;
    private Integer totalPages;
}
