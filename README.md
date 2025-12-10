# 🍕 CookExpress API - Gestión de Menú
## 🛠️ Backend RESTful con Spring Boot


![Sistema de Gestión de Pedidos CookExpress](img/cookexpressapi.png)

[![Java](https://img.shields.io/badge/Java-17+-blue)](https://www.java.com/es/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2+-brightgreen)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Build-Maven-orange)](https://maven.apache.org/)

---

## 🎯 Descripción del Proyecto
Esta API RESTful está diseñada para la gestión completa del menú (platillos) del restaurante CookExpress, proporcionando una interfaz moderna y desacoplada para el frontend.

**Funcionalidad principal:** CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad `Dish`.

## 🏗️ Arquitectura y Buenas Prácticas
Este proyecto sigue una arquitectura hexagonal (por capas) estricta, incorporando los siguientes patrones avanzados, clave para la calidad del código:

| Patrón | Implementación | Propósito |
| :--- | :--- | :--- |
| **Arquitectura de Capas** | `Controller`, `Service`, `Repository` | Separa responsabilidades, siguiendo el principio de S.O.L.I.D. |
| **Service Interface** | **`IDishService`** | Desacopla el `Controller` de la implementación, facilitando el *testing* y el cambio de lógica. |
| **DTOs (Data Transfer Objects)** | `DishRequest` y `DishResponse` | **Seguridad y Contrato.** Evita exponer la Entidad `Dish` al cliente y controla la interfaz de datos. |
| **Mapper** | `DishMapper` | Encargado de la traducción segura entre `DTO` y la Entidad `Dish`. |

## 🚀 Cómo Ejecutar la Aplicación

1.  **Clonar el Repositorio:**
    ```bash
    git clone [https://github.com/LuUMorelScharf/CookExpressAPI.git](https://github.com/LuUMorelScharf/CookExpressAPI.git)
    cd CookExpressAPI
    ```
2.  **Requisitos:** Tener instalado **Java JDK 17+** y **Maven**.
3.  **Ejecución:** Iniciar la aplicación principal desde el IDE o con Maven:
    ```bash
    mvn spring-boot:run
    ```
    La API se iniciará en `http://localhost:8080`.

## 📌 Endpoints de la API (Postman Collection)

Todos los endpoints usan la base URL: `http://localhost:8080/api/dishes`.

| Método | Ruta | Descripción | Request Body (DTO) | Response (DTO) |
| :--- | :--- | :--- | :--- | :--- |
| `GET` | `/` | Lista todos los platillos. | N/A | `List<DishResponse>` |
| `GET` | `/{id}` | Obtiene un platillo por ID. | N/A | `DishResponse` |
| `POST` | `/` | Crea un nuevo platillo. | `DishRequest` | `DishResponse` |
| `PUT` | `/{id}` | Actualiza un platillo existente. | `DishRequest` | `DishResponse` |
| `DELETE` | `/{id}` | Elimina un platillo por ID. | N/A | `void` (200 OK) |
| `GET` | `/filter?name=...` | Filtra platillos por nombre y/o categoría. | N/A | `List<DishResponse>` |

## 🎥 Video Demostración (Proof of Concept)

Aquí puedes ver una explicación detallada de la arquitectura y la demostración funcional de todos los *endpoints* CRUD.

**[PEGA AQUÍ EL LINK DE TU VIDEO DE YOUTUBE]**


