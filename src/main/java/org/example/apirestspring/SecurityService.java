package org.example.apirestspring;

import org.springframework.stereotype.Service;

/**
 * Servicio encargado de validar tokens de autenticación.
 *
 * @author Alejandro Alvarez Merida
 * @version 25-02-2024
 */
@Service
public class SecurityService {

    /**
     * Valida un token de autenticación.
     * @param token El token que se va a validar.
     * @return true si el token es válido, false en caso contrario.
     */
    public Boolean validateToken(String token) {
        return (token.equals("tokeen"));
    }
}

