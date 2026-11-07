//// ESTO HACE PARTE DEL BACK-END. Vive en archivos .java (Controllers, Repositories, ect).
//// Acá en Usuarios.java o parqueadero.java Es la plantilla que dice cómo es un usuario
/// que contiene nombre, contraseña, etc (el Backend), por eso el cliente nunca ve este archivo
/// directamente; donde el cliente ve y elige las opciones en una lista desplegable que
/// quiero es en mi archivo .html (el Frontend, dentro de mi carpeta templates).

package com.proyectofinaleasyparking.proyectofinaleasyparking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "parqueadero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parqueadero
{
    //llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_parqueadero;

    //atributos

    private Integer numero; //En el Service haré que se encargue de calcularlo y asignarlo

    @NotBlank(message = "El tipo de vehículo es obligatorio (moto o carro)")
    private String tipo;

    @Builder.Default
    private String estado = "disponible";

    private Long id_usuario;

}
