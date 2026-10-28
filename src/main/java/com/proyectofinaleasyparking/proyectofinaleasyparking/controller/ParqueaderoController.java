// ESTO HACE PARTE DEL BACK-END. Vive en archivos .java (Controllers, Repositories, ect).
// Es el cerebro que procesa los datos y habla con la base de datos.

// ¡RECORDATORIO SOBRE LOS PUERTOS! (NO CONFUNDIR):
// * El puerto 3306 -> ES EXCLUSIVO DE LA BASE DE DATOS (MySQL). Se configura internamente.
// * El puerto 8080 -> ES PARA ENTRAR A MI API / COMPU (http://localhost:8080/api/parqueadero).
// * El "8080" no se pone aquí en el Controller, se maneja en el archivo 'application.properties'.


/*
  CONTROLADOR:
 *- Este archivo es el "puente" que conecta la base de datos con el HTML.
  * Controla la ruta del "form" (para registrar y editar usuarios nuevos).
  * Controla la ruta del "list" (para mandar la lista de usuarios al HTML).
*/

package com.proyectofinaleasyparking.proyectofinaleasyparking.controller;

import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Parqueadero;
import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Usuarios;
import com.proyectofinaleasyparking.proyectofinaleasyparking.repository.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Colocamos un @RestController porque retorna archivos de tipo JSON y estoy creando la API,
//este @restcontroller le pide a (la clase ParqueaderoController) los datos al ParqueaderoRepository.
// El repositorio va a la base de datos de MySQL, busca los parqueaderos y se los devuelve al controlador.
// Como la clase tiene la etiqueta @RestController, ese controlador empaqueta esos datos
// de la base de datos en formato JSON ({"id": 1, "nombre": "Parqueadero 1"}) y los coloca en la ruta /api/parqueaderos

//La API NO viene de afuera, la estoy creando YO desde aquí.
@RestController
// Colocamos un @RequestMapping para definir la ruta de la API
// Al poner @RestController, significa que YO estoy creando una API y le digo a Java: "Este archivo va a traer datos en formato JSON no olvidar"
@RequestMapping("/api/parqueaderos") //Le dice al servidor que este archivo atiende todo lo que se busque en esta ruta
public class ParqueaderoController
{
    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    //los usuarios que están en parqueadero

    @GetMapping
    public List<Parqueadero> getAll()
    {
        return parqueaderoRepository.findAll();
    }

    //para buscar dato especifico

    @GetMapping("/{numero}")
    public Parqueadero getByNumero(@PathVariable Integer numero)
    {
        return parqueaderoRepository.findByNumero(numero).orElse(null);
    }

    //para crear

    @PostMapping
    public Parqueadero create(@RequestBody Parqueadero parqueadero)
    {
        return parqueaderoRepository.save(parqueadero);
    }

    //para actualizar

    @PutMapping("/{id}")
    public Parqueadero update(@PathVariable Long id, @RequestBody Parqueadero parqueadero)
    {
        parqueadero.setId_parqueadero(id);
        return parqueaderoRepository.save(parqueadero);
    }

    //para eliminar

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id)
    {
        parqueaderoRepository.deleteById(id);
    }

}
