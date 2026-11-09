/*
Es la plantilla que dice cómo es el sorteo
 */

package com.proyectofinaleasyparking.proyectofinaleasyparking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.Id;

@Entity //esto me dice que es una tabla
@Table(name = "sorteo") //el nombre de la tabla
@Getter // se crean los metodos automaticamente paara leer el dato
@Setter // se crean los metodos automaticamente paara modificar el dato
@NoArgsConstructor //Esta, crea un constructor vacio (osea una cajita)
// ¿la necesito para acá? si, para mi sorteo, para que la base y spring creen los registros.
public class Sorteo


{
    /* recuedo que acá se debe colocar esto de primeras, ya que en
   se debe indicar que todo modelo de en spring necesita sabeer
   cual es la lleva primaria
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
}
