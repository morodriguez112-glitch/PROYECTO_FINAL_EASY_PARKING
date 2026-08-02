package com.proyectofinaleasyparking.proyectofinaleasyparking.view;

import com.proyectofinaleasyparking.proyectofinaleasyparking.model.Usuarios;
import com.proyectofinaleasyparking.proyectofinaleasyparking.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// colocamos un @Controller, porque necesitamos que retorne archivos de tipo html
@Controller
public class UsuariosView
{
    @Autowired
    public UsuariosRepository usuariosRepository;

    @GetMapping("/view/usuarios")
    public String list(Model model)
    {
        model.addAttribute("usuarios", usuariosRepository.findAll());
        return "Usuarios/list";
    }

    //Ruta para el formulario, recordemos que en este solo see registran o se editan los usuarios

    @GetMapping("/view/usuarios/formulario")
    public String form(Model model)
    {
        model.addAttribute("usuarios", new Usuarios());
        return "Usuarios/form";
    }

    //el de eliminar, editar y guardar, son acciones que se realizan dentro de la oagina existente.
    //CREACION DE DATOS

    //GUARDAR

    @PostMapping("/view/usuarios/save")
    public String save(@ModelAttribute Usuarios usuarios, RedirectAttributes ra)
    {
        usuariosRepository.save(usuarios);
        ra.addAttribute("message", "Usuario creado correctamente");
        return "redirect:/view/usuarios";
    }

    //EDITAR/ACTUALIZAR

    @GetMapping("/view/usuarios/update/{id}")
    public String update(@PathVariable Long id, Model model)
    {
        Usuarios usuarios = usuariosRepository.findById(id).orElse(null);
        model.addAttribute("usuarios", usuarios);
        return "Usuarios/form";
    }

    //ELIMINAR

    @PostMapping("/view/usuarios/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra)
    {
        usuariosRepository.deleteById(id);
        ra.addAttribute("message", "Usuario eliminado correctamente");
        return "redirect:/view/usuarios";
    }
}
