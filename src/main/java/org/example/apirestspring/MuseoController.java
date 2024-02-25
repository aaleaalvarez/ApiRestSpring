package org.example.apirestspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de museos.
 *
 * @author Alejandro Alvarez Merida
 * @version 25-02-2024
 */
@RestController
@RequestMapping("/web")
public class MuseoController {
    @Autowired
    private MuseoRepository repo;

    @Autowired
    private SecurityService security;

    /**
     * Maneja las solicitudes GET a la raíz del contexto ("/web/").
     * Devuelve una lista de todos los museos.
     * @return Lista de todos los museos.
     */
    @GetMapping("/")
    public List<Museo> home() {
        return repo.findAll();
    }

    /**
     * Maneja las solicitudes GET para buscar museos por ubicación.
     * @param ubicacion Ubicación a buscar.
     * @return Lista de museos en la ubicación especificada.
     */
    @GetMapping("ubicacion/{ubicacion}")
    public List<Museo> getUbicacion(@PathVariable String ubicacion) {
        return repo.getMuseosByUbicacion(ubicacion);
    }

    /**
     * Maneja las solicitudes POST para agregar un nuevo museo.
     * @param museo Objeto Museo a agregar.
     * @param token Token de autenticación.
     * @return ResponseEntity con el nuevo museo agregado o estado de error si la autenticación falla.
     */
    @PostMapping("nuevo")
    public ResponseEntity<Museo> nuevo(@RequestBody Museo museo, @RequestParam String token) {
        if (security.validateToken(token))
            return new ResponseEntity<Museo>(repo.save(museo), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Maneja las solicitudes DELETE para eliminar un museo por su ID.
     * @param id ID del museo a eliminar.
     * @param token Token de autenticación.
     * @return ResponseEntity con el museo eliminado o estado de error si la autenticación falla o el museo no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Museo> delete (@PathVariable Long id, @RequestParam String token) {
        ResponseEntity<Museo> respuesta = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if (security.validateToken(token)) {
            Museo salida = new Museo();
            if (repo.existsById(id)) {
                salida = repo.findById(id).get();
                repo.deleteById(id);
                respuesta = new ResponseEntity<Museo>(salida, HttpStatus.OK);
            }else {
                respuesta = new ResponseEntity<Museo>(salida, HttpStatus.NOT_FOUND);
            }
        }
        return respuesta;
    }
}

