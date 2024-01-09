package com.test.cliente.domain.model.compositeKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationPK {

    private Character documentType;
    private Long document;
}