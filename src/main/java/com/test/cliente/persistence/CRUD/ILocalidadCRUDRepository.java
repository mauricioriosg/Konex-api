package com.test.cliente.persistence.CRUD;

import com.test.cliente.persistence.entity.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocalidadCRUDRepository extends JpaRepository<Localidad, Integer> {
}
