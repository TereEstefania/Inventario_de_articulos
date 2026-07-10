# API Artículos - Talento Tech

Proyecto final del curso **Backend Java - Talento Tech**. Consiste en una API REST desarrollada con **Spring Boot** para la gestión de artículos, implementando las operaciones básicas de un CRUD (Crear, Leer, Actualizar y Eliminar).

## 📋 Descripción

Esta API permite administrar un catálogo de artículos, exponiendo endpoints REST para realizar las operaciones principales sobre los recursos. Fue desarrollada como entrega final del programa de formación en desarrollo backend con Java.

## 🛠️ Tecnologías utilizadas

- **Java**
- **Spring Boot**
- **Spring Web** (para la exposición de endpoints REST)
- **Spring Data JPA** (persistencia de datos)
- **Maven** (gestión de dependencias)
- **Base de datos relacional** (MySQL)
- **Thunder client** (para pruebas de los endpoints)


## 📚 Endpoints principales

| Método | Endpoint             | Descripción                       |
|--------|-----------------------|------------------------------------|
| GET    | `/api/articulos`      | Obtiene el listado de artículos    |
| GET    | `/api/articulos/{id}` | Obtiene un artículo por su ID      |
| POST   | `/api/articulos`      | Crea un nuevo artículo             |
| PUT    | `/api/articulos/{id}` | Actualiza un artículo existente    |
| DELETE | `/api/articulos/{id}` | Elimina un artículo                |



## 🗂️ Estructura del proyecto

```
src/
 └── main/
     ├── java/
     │   └── com/talento/articulos/
     │       ├── controller/    # Controladores REST
     │       ├── service/       # Lógica de negocio
     │       ├── repository/    # Acceso a datos (JPA)
     │       ├── model/         # Entidades
     │       └── ArticulosApplication.java
     └── resources/
         └── application.properties
```

## 🎥 Video de presentación

Podés ver la presentación completa del proyecto en el siguiente enlace: *https://drive.google.com/file/d/1hBHMF3wAEeCgVQJ3jQYi42kqT2Jr35Yv/view?usp=sharing*

Music by <a href="https://pixabay.com/es/users/joyinsound-51634429/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=403408">JoyInSound</a> from <a href="https://pixabay.com//?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=403408">Pixabay</a>

## 😶‍🌫️ Autora

**Teresa Fernández** 

## 📄 Licencia

Este proyecto fue desarrollado con fines académicos como entrega final del curso Talento Tech - Backend Java, 1er cuatrimestre 2026.
