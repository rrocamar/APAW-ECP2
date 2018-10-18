# APAW. ECP2. Arquitectura de un mini API-Rest simulado
#### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)

# Descripción
Este es el desarrollo de la segunda práctica de Patrones de Diseño, correspondiente a la asignatura *Arquitectura y Patrones para Aplicaciones Web*.

## Diseño de entidades
![themes-architecture-diagram](https://github.com/rrocamar/APAW-ECP2-RamonRoca/blob/develop/docs/DiagramaDeClases.png)

## Arquitectura
![themes-entities-class-diagram](https://github.com/rrocamar/APAW-ECP2-RamonRoca/blob/develop/docs/themes-architecture-diagram.png)

### Responsabilidades
#### Dispatcher
* Centraliza las peticiones y hace de repartidor
* Recupera los datos de la petición y los pasa como parámetros de método
* Captura las excepciones y las convierte en errores Http
#### restControllers
* Define el path del recurso
* Valida la entrada
* Traspasa la petición a los controladores de la capa de negocio
#### businessControllers
* Procesa la petición, apoyándose en los DAO’s
* Crea las entidades a partir de los DTO’s
* Gestiona la respuesta a partir de las entidades. Delega en los DTO’s la creación a partir de la entidad
#### daos
* Gestionan la BD
#### entities
* Son las entidades persistentes en la BD

## API
### POST /empleados
#### Parámetros del cuerpo
- `nombre`: String (**requerido**)
- `salario`: double
#### Respuesta
- 200 OK
  - `id`: String
- 403 BAD_REQUEST
---
### GET /cartas/{id}
#### Respuesta
- 200 OK
  - `nombre`: String
  - `fechaValidez`: LocalDateTime
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### UPDATE /empleados/{id}
#### Parámetros del cuerpo
- `nombre`: String
- `salario`: double
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### PATCH /cartas/{id}
#### Parámetros del cuerpo
- `nombre`: String
- `fechaValidez`: LocalDateTime
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### DELETE /cartas/{id}
#### Respuesta
- 200 OK
---
### GET /empleados/{id}
#### Respuesta
- 200 OK
  - `nombre`: String
  - `salario`: double
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### POST /restaurantes
#### Parámetros del cuerpo
- `nombre`: String (**requerido**)
- `direccion`: String
- `tipo`: Cocina
- `idCarta`: String
#### Respuesta
- 200 OK
  - `id`: String
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### POST /restaurantes/{id}/carta
#### Parámetros del cuerpo
- `nombre`: String (**requerido**)
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### POST /restaurantes/{id}/empleado
#### Parámetros del cuerpo
- `nombre`: String (**requerido**)
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### Tecnologías utilizadas
* Java
* Maven
* IntelliJ
* GitHub
* Travis
* Sonar

[![Build Status](https://travis-ci.org/rrocamar/APAW-ECP2-RamonRoca.svg?branch=develop)](https://travis-ci.org/rrocamar/APAW-ECP2-RamonRoca)

##### Autor: Ramón Roca Martínez
