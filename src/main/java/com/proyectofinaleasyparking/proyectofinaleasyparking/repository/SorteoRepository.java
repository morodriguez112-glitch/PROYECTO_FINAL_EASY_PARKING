///// El repositorio es el que realmente guarda la plantillla que
///// esta llena de info de la base de datos (gracias a la extends JpaRepository)


package com.proyectofinaleasyparking.proyectofinaleasyparking.repository;

import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Sorteo;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SorteoRepository extends JpaRepository<Sorteo, Long>
{
}

