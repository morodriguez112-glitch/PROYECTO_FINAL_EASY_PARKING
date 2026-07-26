package com.proyectofinaleasyparking.proyectofinaleasyparking.controller;

import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Parqueadero;
import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Usuarios;
import com.proyectofinaleasyparking.proyectofinaleasyparking.repository.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parqueaderos")
public class ParqueaderoController
{
    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    //los usuarios que estan en parqueadero

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
