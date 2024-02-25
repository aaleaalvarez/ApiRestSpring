# Documentación API de Museos

La API de Museos proporciona acceso a operaciones relacionadas con museos, permitiendo obtener información, añadir nuevos museos y eliminar museos existentes.

## Endpoints

### Obtener todos los museos

- **URL**: `/web/`
- **Método**: `GET`
- **Descripción**: Retorna una lista de todos los museos.
- **Respuesta de Ejemplo**:

```json
[
  {
    "museoID": 1,
    "nombre": "Museo del Prado",
    "ubicacion": "Madrid",
    "descripcion": "Uno de los museos más importantes del mundo, con una colección de arte europeo desde el siglo XII hasta el inicio del XIX."
  },
  {
    "museoID": 2,
    "nombre": "Museo Británico",
    "ubicacion": "Londres",
    "descripcion": "Alberga una vasta colección de obras y artefactos de todo el mundo."
  }
]
```

### Obtener museos por ubicación

- **URL**: /web/ubicacion/{ubicacion}
- **Método**: GET
- **Parámetros URL**: ubicacion (string) - La ubicación de los museos a buscar.
- **Descripción**: Retorna una lista de museos filtrados por su ubicación.
- **Respuesta de Ejemplo**:

```json
[
  {
    "museoID": 3,
    "nombre": "Museo del Louvre",
    "ubicacion": "París",
    "descripcion": "El museo de arte más visitado del mundo y alberga la Mona Lisa."
  },
  {
    "museoID": 6,
    "nombre": "Museo de Orsay",
    "ubicacion": "París",
    "descripcion": "Alberga obras de arte francés principalmente de la época impresionista."
  }
]
```

### Añadir un nuevo museo
- **URL**: /web/nuevo
- **Método**: POST
- **Parámetros**: token (string) en la query para autenticación.
- **Cuerpo de la petición**: Objeto JSON con la información del museo.
- **Descripción**: Añade un nuevo museo a la base de datos.
- **Cuerpo de la petición de ejemplo**:

```json
{
  "museoID": 0,
  "nombre": "ejemplo",
  "ubicacion": "ejemplo",
  "descripcion": "ejemplo"
}
```
- **Respuesta de Ejemplo**:

```json
{
  "museoID": 12,
  "nombre": "ejemplo",
  "ubicacion": "ejemplo",
  "descripcion": "ejemplo"
}
```

### Eliminar un museo
- **URL**: /web/{id}
- **Método**: DELETE
- **Parámetros URL**: id (long) - El ID del museo a eliminar.
- **Parámetros**: token (string) en la query para autenticación.
- **Descripción** : Elimina un museo basado en el ID proporcionado.
- **Respuesta de Ejemplo (éxito)**:

```json
{
  "museoID": 12,
  "nombre": "ejemplo",
  "ubicacion": "ejemplo",
  "descripcion": "ejemplo"
}
```
- **Respuesta de Ejemplo (no encontrado)**:

```json
404 Not Found
```
- **Respuesta de Ejemplo (no autorizado)**:

```json
401 Unauthorized
```

## Autenticación:

La API utiliza tokens para la autenticación. Debes incluir un parámetro token válido en las peticiones de crear y eliminar para realizar operaciones que modifican los datos.
