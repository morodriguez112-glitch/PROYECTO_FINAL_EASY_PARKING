package com.proyectofinaleasyparking.proyectofinaleasyparking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecuperarController {

    @GetMapping("/recuperar")
    public String mostrarRecuperarContraseña() {
        return "Usuarios/recuperar"; //acá estoy diciendo "Busca en templates/Usuarios/recuperar.html"
    }

}