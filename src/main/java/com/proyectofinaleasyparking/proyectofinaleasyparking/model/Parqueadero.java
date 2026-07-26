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
