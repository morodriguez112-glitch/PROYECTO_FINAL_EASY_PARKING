//// ESTO HACE PARTE DEL BACK-END. Vive en archivos .java (Controllers, Repositories, ect).
//// Es el cerebro que procesa los datos y habla con la base de datos.
/// El repositorio es el que realmente guarda la plantillla que
/// esta llena de info de la base de datos (gracias a la extends JpaRepository).

package com.proyectofinaleasyparking.proyectofinaleasyparking.repository;

import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>
{
}
