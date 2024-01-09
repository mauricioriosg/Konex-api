package com.test.cliente.persistence.mapper;

import com.test.cliente.domain.model.Locality;
import com.test.cliente.persistence.entity.Localidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ILocalidadMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "code"),
            @Mapping(source = "departamento", target = "department"),
            @Mapping(source = "ciudad", target = "city"),
    })
    Locality toLocality(Localidad localidad);

    List<Locality> toLocalityList(List<Localidad> localidadList);

    @InheritInverseConfiguration
    Localidad fromLocality(Locality locality);

    List<Localidad> fromLocalityList(List<Locality> localityList);
}
