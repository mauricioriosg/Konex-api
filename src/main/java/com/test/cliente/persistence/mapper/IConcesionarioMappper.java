package com.test.cliente.persistence.mapper;

import com.test.cliente.domain.model.Dealer;
import com.test.cliente.persistence.entity.Concesionario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IConcesionarioMappper {

    @Mappings({
            @Mapping(source = "codigo", target = "code"),
            @Mapping(source = "nombreConcesionario", target = "dealerName"),
            @Mapping(source = "razonSocial", target = "socialReason"),
    })
    Dealer toAffiliate(Concesionario concesionario);

    List<Dealer> toDealerList(List<Concesionario> concesionarioList);

    @InheritInverseConfiguration
    Concesionario fromDealer(Dealer dealer);

    List<Concesionario> fromDealerList(List<Dealer> dealerList);
}
