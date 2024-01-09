package com.test.cliente.persistence.mapper;

import com.test.cliente.domain.model.Dealer;
import com.test.cliente.persistence.entity.Concesionario;
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
public class IConcesionarioMappperImpl implements IConcesionarioMappper {

    @Override
    public Dealer toAffiliate(Concesionario concesionario) {
        if ( concesionario == null ) {
            return null;
        }

        Dealer dealer = new Dealer();

        dealer.setCode( concesionario.getCodigo() );
        dealer.setDealerName( concesionario.getNombreConcesionario() );
        dealer.setSocialReason( concesionario.getRazonSocial() );

        return dealer;
    }

    @Override
    public List<Dealer> toDealerList(List<Concesionario> concesionarioList) {
        if ( concesionarioList == null ) {
            return null;
        }

        List<Dealer> list = new ArrayList<Dealer>( concesionarioList.size() );
        for ( Concesionario concesionario : concesionarioList ) {
            list.add( toAffiliate( concesionario ) );
        }

        return list;
    }

    @Override
    public Concesionario fromDealer(Dealer dealer) {
        if ( dealer == null ) {
            return null;
        }

        Concesionario concesionario = new Concesionario();

        concesionario.setCodigo( dealer.getCode() );
        concesionario.setNombreConcesionario( dealer.getDealerName() );
        concesionario.setRazonSocial( dealer.getSocialReason() );

        return concesionario;
    }

    @Override
    public List<Concesionario> fromDealerList(List<Dealer> dealerList) {
        if ( dealerList == null ) {
            return null;
        }

        List<Concesionario> list = new ArrayList<Concesionario>( dealerList.size() );
        for ( Dealer dealer : dealerList ) {
            list.add( fromDealer( dealer ) );
        }

        return list;
    }
}
