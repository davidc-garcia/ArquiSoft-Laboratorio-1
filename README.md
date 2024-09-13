# Primer Proyecto Back-end & Front-end - Arquitectura de Software

Este es el primer proyecto de Back-end y Front-end desarrollado para el curso de **Arquitectura de Software**.

## Integrantes

Daniel Andrés Agudelo García  
Paulina García Aristizábal  
David Camilo García Echavarría  
Juan Sebastián Ortiz Tangarife  

## Descripción

Este proyecto incluye la implementación de un sistema de gestión de vuelos con una base de datos H2 y una colección de peticiones en Postman para interactuar con el API.

## Introducción

Se realizó una aplicación llamada FlightSearch que permite a los usuarios la búsqueda de vuelos disponibles entre un rango de fechas a elección del usuario. Cada vuelo incluye los siguientes detalles: fecha de salida, fecha de llegada, lugar de origen, destino, precio, tipo de vuelo y la aeronave en la que se realizará el vuelo.

La aplicación cuenta con dos partes fundamentales para su correcto funcionamiento: el backend y el frontend. El backend implementa la lógica de negocio y la persistencia de datos, mientras que el frontend proporciona una interfaz intuitiva para los usuarios.

## Objetivos

- Proporcionar a los usuarios una forma sencilla y rápida de buscar vuelos dentro de un rango de fechas específico.
- Mostrar detalles completos de los vuelos disponibles, incluyendo el origen, destino, fecha y precio de cada vuelo.
- Integrarse con una API REST en el backend para obtener datos de vuelos.
- Consumir los datos proporcionados por la API y mostrarlos de manera adecuada en la interfaz de usuario.
- Entender el funcionamiento y configuración de Apache Maven y su importancia dentro del desarrollo del proyecto.
- Aplicar una arquitectura básica de 3 o N capas para el desarrollo de una aplicación web.

## Herramientas Utilizadas

- IDE: IntelliJ, Visual Studio Code
- Back-end: Spring Boot, Java, Apache Maven 3.5, JDK 17
- Base de Datos: H2
- Pruebas API: Postman
- Front-end: Vite + ReactJS, NodeJS
- Web Browser: Chrome

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
5. Para ejecutar el front-end: Abrir la consola, escribir el comando `cd Front`.
6. Una vez ubicado en esta carpeta, de nuevo en la consola se escribe el comando `npm run dev`.
7. Abrirlo de manera local en el enlace que le fue proporcionado dentro de la consola al ejecutar el comando.

## Backend

### Arquitectura

Se propone una arquitectura de tipo MVC (Modelo - Vista - Controlador):

- Modelo: La clase `Flight` representa los datos de los vuelos.
- Controlador: `FlightController` maneja las solicitudes relacionadas con la búsqueda de vuelos.
- Servicio: `FlightService` contiene la lógica de negocio para la búsqueda de vuelos.
- Persistencia de Datos: Utiliza JPARepository para la gestión de datos en la base de datos.

### Procedimiento
- Modelo: Se creó la clase `Flight` con los atributos necesarios.
- Controlador: `FlightController` gestiona las solicitudes HTTP y llama al servicio.
- Repositorio: Utiliza `JpaRepository` para acceder y filtrar los datos de vuelos.
- Servicio: `FlightService` maneja la lógica de negocio para encontrar vuelos.

## Frontend

### Arquitectura

La arquitectura del frontend sigue un enfoque basado en componentes utilizando React para crear una SPA.

- Componentes: `FlightSearch.jsx` gestiona la búsqueda de vuelos y muestra los resultados.
- Gestión de estados: Utiliza el hook `useState` de React.
- Solicitud y gestión de datos: Se realiza mediante `fetch()` para obtener los datos del backend.
- Interfaz del usuario: Desarrollada usando JSX y CSS.

### Procedimiento

- Interfaz: `FlightSearch.jsx` presenta un formulario con filtros opcionales.
- URL: Utiliza un endpoint local para las solicitudes.
- Consulta: Realiza una solicitud HTTP GET para obtener los vuelos disponibles.
- Resultados: Los datos se muestran en una tabla.

## Prueba y Depuración

1. **Ejecución de la Aplicación:** Inicie el backend y el frontend por separado.
2. **Prueba de Funcionalidad:** Verifique que la búsqueda de vuelos funcione correctamente.


## Conclusiones

Se cumplieron los objetivos del proyecto, implementando una arquitectura MVC en el backend y una interfaz intuitiva en el frontend. La integración con la API REST y las nuevas funcionalidades añadidas mejoraron la búsqueda de vuelos.
