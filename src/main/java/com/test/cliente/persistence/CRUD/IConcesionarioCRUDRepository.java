package com.test.cliente.persistence.CRUD;

import com.test.cliente.persistence.entity.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConcesionarioCRUDRepository extends JpaRepository<Concesionario, Integer> {
}
