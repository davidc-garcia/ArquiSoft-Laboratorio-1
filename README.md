# Primer Proyecto Back-end & Front-end - Arquitectura de Software

Este es el primer proyecto de Back-end y Front-end desarrollado para el curso de **Arquitectura de Software**.

## Integrantes

Daniel Andrés Agudelo García
Paulina García Aristizábal
David Camilo García Echavarría
Juan Sebastián Ortiz Tangarife

## Descripción
Este proyecto incluye la implementación de un sistema de gestión de vuelos con una base de datos H2 y una colección de peticiones en Postman para interactuar con el API.

## Base de Datos
El proyecto utiliza una base de datos H2 en memoria, la cual es accesible desde la siguiente URL:
- **URL**: [localhost:8080/h2-console](http://localhost:8080/h2-console/)
- **Usuario**: `sa`
- **Contraseña**: `sa`

### Querys de Inserción
Los querys para poblar la base de datos están disponibles en el archivo: `Laboratorio 1.txt`.

## Colección de Postman
Para realizar pruebas en el sistema, puedes importar la colección de Postman que se encuentra en el archivo:
- `Flights.postman_collection.json`

Esta colección incluye todas las peticiones necesarias para interactuar con el API de vuelos, incluyendo operaciones CRUD.

## Instrucciones para Ejecutar
1. Clona el repositorio.
   ```bash
   git clone https://github.com/davidc-garcia/ArquiSoft-Laboratorio-1.git
2. Navega a la carpeta del proyecto e inicia la aplicación.
3. Abre el navegador y ve a la consola de H2 en la dirección localhost:8080/h2-console.
4. Importa la colección de Postman en Postman para realizar las pruebas en el API.
5. Para ejecutar el front-end: Abrir la consola, escribir el comando cd Front.
6. Una vez ubicado en esta carpeta, de nuevo en la consola se escribe el comando npm run dev.
7. Abrirlo de manera local en el enlace que le fue proporcionado dentro de la consola al ejecutar el comando.

Herramientas Utilizadas
- IDE: IntelliJ, Visual Studio Code
- Back-end: Spring Boot, Java, Apache Maven 3.5, JDK 17
- Base de Datos: H2
- Pruebas API: Postman
- Front-end: Vite + ReactJS, NodeJS
- Web Browser: Chrome

