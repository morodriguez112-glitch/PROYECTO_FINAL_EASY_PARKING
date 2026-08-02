package com.proyectofinaleasyparking.proyectofinaleasyparking.view;

import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Parqueadero;
import com.proyectofinaleasyparking.proyectofinaleasyparking.repository.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// colocamos un @Controller, porque necesitamos que retorne archivos de tipo html
@Controller
public class ParqueaderoView
{
    @Autowired
    public ParqueaderoRepository parqueaderoRepository;

    // metodo  para listar los parqueaderos
    @GetMapping("/view/parqueadero")
    public String list(Model model)
    {
        model.addAttribute("parqueaderos", parqueaderoRepository.findAll());
        return "Parqueadero/list"; //Esta es donde conectamos con la la carpeta de lista.html
    }

    // metodo  para abrir el formulario de registro
    @GetMapping("/view/parqueadero/formulario")
    public String form(Model model)
    {
        model.addAttribute("parqueadero", new Parqueadero());
        return "Parqueadero/form";
    }

    // metodo para guardar o que quiera registrar los datos del parqueadero
    @PostMapping("/view/parqueadero/save")
    public String save(@ModelAttribute Parqueadero parqueadero, RedirectAttributes ra)
    {
        parqueaderoRepository.save(parqueadero);
        ra.addAttribute("message", "Parqueadero guardado correctamente");
        return "redirect:/view/parqueadero";
    }

    // metodo para editar un parqueadero existente buscando por el id
    @GetMapping("/view/parqueadero/update/{id}")
    public String update(@PathVariable Long id, Model model)
    {
        Parqueadero parqueadero = parqueaderoRepository.findById(id).orElse(null);
        model.addAttribute("parqueadero", parqueadero);
        return "Parqueadero/form";
    }

    // metodo para eliminar un registro
    @PostMapping("/view/parqueadero/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra)
    {
        parqueaderoRepository.deleteById(id);
        ra.addAttribute("message", "Parqueadero eliminado correctamente");
        return "redirect:/view/parqueadero";
    }
}