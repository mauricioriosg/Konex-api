package com.test.cliente.persistence.mapper;

import com.test.cliente.domain.model.Locality;
import com.test.cliente.persistence.entity.Localidad;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-09T03:01:42-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
@Component
public class ILocalidadMapperImpl implements ILocalidadMapper {

    @Override
    public Locality toLocality(Localidad localidad) {
        if ( localidad == null ) {
            return null;
        }

        Locality locality = new Locality();

        locality.setCode( localidad.getCodigo() );
        locality.setDepartment( localidad.getDepartamento() );
        locality.setCity( localidad.getCiudad() );

        return locality;
    }

    @Override
    public List<Locality> toLocalityList(List<Localidad> localidadList) {
        if ( localidadList == null ) {
            return null;
        }

        List<Locality> list = new ArrayList<Locality>( localidadList.size() );
        for ( Localidad localidad : localidadList ) {
            list.add( toLocality( localidad ) );
        }

        return list;
    }

    @Override
    public Localidad fromLocality(Locality locality) {
        if ( locality == null ) {
            return null;
        }

        Localidad localidad = new Localidad();

        localidad.setCodigo( locality.getCode() );
        localidad.setDepartamento( locality.getDepartment() );
        localidad.setCiudad( locality.getCity() );

        return localidad;
    }

    @Override
    public List<Localidad> fromLocalityList(List<Locality> localityList) {
        if ( localityList == null ) {
            return null;
        }

        List<Localidad> list = new ArrayList<Localidad>( localityList.size() );
        for ( Locality locality : localityList ) {
            list.add( fromLocality( locality ) );
        }

        return list;
    }
}
