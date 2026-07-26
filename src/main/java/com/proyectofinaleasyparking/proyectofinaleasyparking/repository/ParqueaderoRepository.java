package com.proyectofinaleasyparking.proyectofinaleasyparking.repository;


import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Long>
{
    List<Parqueadero> estado(String estado);
    Optional<Parqueadero> findByNumero(Integer numero);
}
