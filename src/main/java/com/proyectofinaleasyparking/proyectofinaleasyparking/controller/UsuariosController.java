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
