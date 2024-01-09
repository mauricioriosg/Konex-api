package com.test.cliente.domain.model;

import com.test.cliente.domain.model.compositeKey.IdentificationPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private IdentificationPK identificationPK;

    @Pattern(regexp="[A-Z]{1,20}",message="surname no debe contener caracteres especiales")
    private String firstSurname;

    @Pattern(regexp="[A-Z]{1,20}",message="secondSurname no debe contener caracteres especiales")
    private String secondSurname;

    @Pattern(regexp="[A-Z]{1,20}",message="firstName no debe contener caracteres especiales")
    private String firstName;

    @Pattern(regexp="[A-Z]{1,20}",message="surname no debe contener caracteres especiales")
    private String secondName;

    private Boolean state;

    private Long localityID;

    private Long dealerId;

    private LocalDateTime registrationDate;

    private LocalDateTime modificationDate;
}
