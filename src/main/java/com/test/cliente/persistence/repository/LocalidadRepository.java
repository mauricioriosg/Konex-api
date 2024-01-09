package com.test.cliente.persistence.repository;

import com.test.cliente.domain.model.Locality;
import com.test.cliente.domain.repository.ILocalityRepository;
import com.test.cliente.persistence.CRUD.ILocalidadCRUDRepository;
import com.test.cliente.persistence.mapper.ILocalidadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocalidadRepository implements ILocalityRepository {

    @Autowired
    private ILocalidadMapper localidadMapper;

    @Autowired
    private ILocalidadCRUDRepository localidadCRUDRepository;

    @Override
    public List<Locality> getLocality() {
        return localidadMapper.toLocalityList(localidadCRUDRepository.findAll());
    }
}
