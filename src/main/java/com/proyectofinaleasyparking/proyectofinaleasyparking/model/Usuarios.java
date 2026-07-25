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

    @NotBlank(message = "La contraseña es obligatorio")
    private String contrasena;



}
