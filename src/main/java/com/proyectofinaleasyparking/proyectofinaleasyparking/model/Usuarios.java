//// ESTO HACE PARTE DEL BACK-END. Vive en archivos .java (Controllers, Repositories, ect).
//// Es el cerebro que procesa los datos y habla con la base de datos.

package com.proyectofinaleasyparking.proyectofinaleasyparking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuarios
{
    //metodo de llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    //metodo para los atributos

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotNull(message = "El documento es obligatorio")
    private Integer documento;

    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @NotBlank(message = "El telefono es obligatorio")
    private String telefono;

    private Long rol;

    @NotBlank(message = "La placa es obligatoria")
    private String placa;

    //// Quitamos o comentamos la validación estricta para que pueda ir en blanco al editar
    /// @NotBlank(message = "La contraseña es obligatorio")
    ///     private String contrasena; asi debe quedar si queremos que la contraseña vaya en blanco
    private String contrasena;


    /* concepto de etiquetas para no olvidar

   1. @NotNull:
      ¿Qué hace?: Valida que el campo NO sea nulo ("null").
      Cuándo usarlo: Ideal para números (Long, Integer), fechas o
      llaves foráneas que siempre deben venir con un valor asignado.

   2. @NotEmpty:
      ¿Qué hace?: Valida que el campo NO sea nulo y que su tamaño
      o longitud sea mayor a cero (no esté vacío `""`).
      Cuándo usarlo: Para textos o listas que requieren al menos un carácter o elemento.

   3. @NotBlank:
      ¿Qué hace?: Es la más estricta para textos. Valida que no sea nulo,
      que no esté vacío Y que no tenga solo espacios en blanco ("   ").
      Cuándo usarlo: Para campos de texto obligatorios como nombres,
      correos o contraseñas (cuando se están creando por primera vez).

   ¡OJO CUANDOO EDITO!
   Si coloco @NotBlank o @NotNull en un campo como la contraseña, el software
   exigirá que se llene al enviar el formulario.
   Si estoy actualizando un usuario y quiero dejarlo en blanco para
   conservar la clave vieja, estas etiquetas bloquearán el proceso a
   menos que programes una lógica especial en el controlador.
*/

}
