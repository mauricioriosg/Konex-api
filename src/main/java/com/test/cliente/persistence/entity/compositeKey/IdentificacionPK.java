package com.test.cliente.persistence.entity.compositeKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificacionPK implements Serializable {

    @Column(columnDefinition = "NUMERIC(11,0)", name = "documento", nullable = false)
    private Long documento;

    @Column(name = "tipo_documento", columnDefinition = "character(1)", nullable = false)
    private Character tipoDocumento;
}
