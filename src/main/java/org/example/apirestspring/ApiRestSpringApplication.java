package org.example.apirestspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot para el API REST.
 * Esta clase contiene el método principal para arrancar la aplicación.
 *
 * @author Alejandro Álvarez Merida
 * @version 25-02-2024
 */
@SpringBootApplication
public class ApiRestSpringApplication {

    /**
     * El método principal de la aplicación.
     *
     * @param args Los argumentos de línea de comandos pasados al programa.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiRestSpringApplication.class, args);
    }

}
