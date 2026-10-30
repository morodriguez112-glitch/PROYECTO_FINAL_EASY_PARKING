// ESTO HACE PARTE DEL BACK-END. Vive en archivos .java (Controllers, Repositories, ect).
// Es el cerebro que procesa los datos y habla con la base de datos.

// ¡RECORDATORIO SOBRE LOS PUERTOS! (NO CONFUNDIR):
// * El puerto 3306 -> ES EXCLUSIVO DE LA BASE DE DATOS (MySQL). Se configura internamente.
// * El puerto 8080 -> ES PARA ENTRAR A MI API / COMPU (http://localhost:8080/api/usuarios).
// * El "8080" no se pone aquí en el Controller, se maneja en el archivo 'application.properties'.


/*
  CONTROLADOR:
 *- Este archivo es el "puente" que conecta la base de datos con el HTML.
  * Controla la ruta del "form" (para registrar y editar usuarios nuevos).
  * Controla la ruta del "list" (para mandar la lista de usuarios al HTML).
*/

package com.proyectofinaleasyparking.proyectofinaleasyparking.controller;

import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Usuarios;
import com.proyectofinaleasyparking.proyectofinaleasyparking.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//colocamos un @RestController porque retorna archivos de tipo JSON
@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController
{

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public List<Usuarios> getAll()
    {
        return usuariosRepository.findAll();
    }

    //metodo para dato especifico

    @GetMapping("/{id}")
    public Usuarios getById(@PathVariable Long id)
    {
        return usuariosRepository.findById(id).orElse(null);
    }

    //metodo crear

    @PostMapping
    public Usuarios create(@RequestBody Usuarios usuarios)
    {
        return usuariosRepository.save(usuarios);
    }

    //metodo actualizar

    @PutMapping("/{id}")
    public Usuarios update(@PathVariable Long id, @RequestBody Usuarios usuarios)
    {
        // 1. Buscamos el usuario que ya existe en la base de datos por su ID
        Usuarios usuarioExistente = usuariosRepository.findById(id).orElse(null);

        // 2. Si el usuario dejó la contraseña en blanco o nula al editar
        if (usuarios.getContrasena() == null || usuarios.getContrasena().isEmpty()) {
            if (usuarioExistente != null) {
                //le devolvemos la contraseña vieja que ya estaba guardada para que no se borre
                usuarios.setContrasena(usuarioExistente.getContrasena());
            }
        }

        usuarios.setId_usuario(id);
        return usuariosRepository.save(usuarios);
    }

    //metodo eliminar

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        usuariosRepository.deleteById(id);
    }



}
