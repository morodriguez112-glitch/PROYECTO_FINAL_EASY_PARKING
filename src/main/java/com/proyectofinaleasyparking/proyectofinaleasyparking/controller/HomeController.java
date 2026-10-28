//Esto es lo que me dice que esta carpeta vive el archivo dentro de mi proyecto,  en Spring Boot,
//todos los controladores deben vivir en el paquete raíz de mi proyecto para que Spring Boot los detecte automáticamente.
package com.proyectofinaleasyparking.proyectofinaleasyparking.controller;

//Estos dos import, le estoy diciendo a Java que voy a usar las anotación @Controller y  @GetMapping,
// para que Java sepa que este archivo es un controlador y que va a manejar rutas HTTP GET. Para que Java
// busque esas herramientas en las librerías de Spring que ya descargue en mi proyecto.
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// esta etiqueta @controller Le avisa a Spring Boot que esta clase va a manejar vistas (páginas HTML)
// o sea la página que va a ver una persona en el navegador
@Controller
public class HomeController {

    // Recodar que el @getmapping es para pedir, traer o consultar información
    @GetMapping("/")
    public String mostrarHome() {
        return "home"; //este return es para indicarle a Thymeleaf "Búscame un archivo en la carpeta templates que se llame exactamente home.html, agárralo y muéstraselo al usuario en la pantalla"
    }
}
