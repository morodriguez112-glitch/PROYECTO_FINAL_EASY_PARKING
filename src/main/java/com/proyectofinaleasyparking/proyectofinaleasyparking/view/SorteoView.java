/*
  ¿CÓMO ES QUE CONECTO EL FRONT CON EL BACK AQUÍ?

  1. ¡NO NECESITO "FETCH"! Como estoy usando Thymeleaf (que viene en las dependencias
     de Spring Boot que descargue al comienzo), la conexión es AUTOMÁTICA por dentro del servidor.
  2. Este archivo (la clase View con @Controller) actúa como el diciendo:
     * Ve a la base de datos a través del Repositorio (ejemplo: sorteoRepository).
     * Trae los datos y los empaqueta usando el "Model"
     * Busca el archivo HTML correspondiente en la carpeta src/main/resources/templates/Sorteo/sorte.html
  3. El motor de Thymeleaf lee el HTML, le inyecta los datos de Java por debajo
     y le entrega la página lista y linda al navegador de mi usuario.
*/

package com.proyectofinaleasyparking.proyectofinaleasyparking.view;

public class SorteoView {
}
