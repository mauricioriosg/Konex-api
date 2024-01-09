package com.test.cliente.persistence.repository;

import com.test.cliente.domain.model.Dealer;
import com.test.cliente.domain.repository.IDealerRepository;
import com.test.cliente.persistence.CRUD.IConcesionarioCRUDRepository;
import com.test.cliente.persistence.mapper.IConcesionarioMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConcesionarioRepository implements IDealerRepository {

    @Autowired
    private IConcesionarioMappper concesionarioMappper;

    @Autowired
    private IConcesionarioCRUDRepository concesionarioCRUDRepository;


    @Override
    public List<Dealer> getDealerList() {
        return concesionarioMappper.toDealerList(concesionarioCRUDRepository.findAll());
    }
}
