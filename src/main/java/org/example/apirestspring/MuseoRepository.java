package org.example.apirestspring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz de repositorio para la entidad Museo.
 * Proporciona métodos para acceder y manipular datos relacionados con los museos en la base de datos.
 *
 * @author Alejandro Alvarez Merida
 * @version 25-02-2024
 */
public interface MuseoRepository extends JpaRepository<Museo, Long> {

    /**
     * Obtiene una lista de museos que se encuentran en una ubicación específica.
     * @param ubicacion La ubicación para la cual se desean obtener los museos.
     * @return Lista de museos que se encuentran en la ubicación especificada.
     */
    public List<Museo> getMuseosByUbicacion(String ubicacion);
}

