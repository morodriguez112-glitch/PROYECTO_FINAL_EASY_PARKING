//// ESTO HACE PARTE DEL BACK-END. Vive en archivos .java (Controllers, Repositories, ect).
//// Es el cerebro que procesa los datos y habla con la base de datos.

package com.proyectofinaleasyparking.proyectofinaleasyparking.repository;

import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>
{
}
