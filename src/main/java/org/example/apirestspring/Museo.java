package org.example.apirestspring;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un museo en el sistema.
 *
 * @author Alejandro Alvarez Merida
 * @version 25-02-2024
 */
@Data
@Entity
@Table(name = "Museos")
public class Museo {
    /**
     * Identificador único del museo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long museoID;

    /**
     * Nombre del museo.
     */
    private String nombre;

    /**
     * Ubicación del museo.
     */
    private String ubicacion;

    /**
     * Descripción del museo.
     */
    private String descripcion;
}
