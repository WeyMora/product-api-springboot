# 📦 API REST de Productos - Spring Boot & PostgreSQL

[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue.svg)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Compose-blueviolet.svg)](https://www.docker.com/)

API RESTful desarrollada en Java con **Spring Boot** para la administración y gestión de productos. El proyecto está diseñado siguiendo las mejores prácticas de arquitectura limpia en capas, manejo seguro de variables de entorno y virtualización de la base de datos con **Docker Compose**.

---

## 🛠️ Tecnologías y Herramientas

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot (Spring Web, Spring Data JPA)
* **Base de Datos:** PostgreSQL 16
* **Infraestructura & Contenedores:** Docker & Docker Compose
* **Gestor de BD Web:** Adminer
* **Construcción:** Maven
* **Pruebas de Endpoints:** Postman

---

## 🏛️ Arquitectura del Proyecto

El proyecto implementa una **arquitectura por capas** para garantizar la separación de responsabilidades, escalabilidad y un código desacoplado:

```text
  [ Cliente / Postman ]
           │
     (HTTP Request)
           ▼
  [ Controller Layer ]  ---> @RestController (Gestión de endpoints HTTP)
           │
           ▼
  [ Service Layer ]     ---> @Service (Lógica de negocio e intermediación)
           │
           ▼
  [ Repository Layer ]  ---> @Repository / JpaRepository (Acceso a BD)
           │
           ▼
  [ Base de Datos ]     ---> PostgreSQL 16 (Contenedor Docker)
