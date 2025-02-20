# E-commerce Service Inditex

Este proyecto es un microservicio de e-commerce desarrollado con Java y Spring Boot, siguiendo la arquitectura hexagonal. Su objetivo es gestionar los precios de productos en función de la marca y la fecha de aplicación.

## Arquitectura

El servicio sigue una **arquitectura hexagonal**, dividiéndose en:

- **Capa de Aplicación**: Contiene los casos de uso y la lógica de negocio principal.
- **Capa de Dominio**: Define las entidades, valores y puertos de salida.
- **Capa de Infraestructura**: Implementa adaptadores para la persistencia de datos y la exposición de la API REST.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MapStruct**
- **Lombok**
- **OpenAPI Generator**
- **Base de datos H2 (para pruebas locales)**
- **PostgreSQL (para entorno productivo)**


## Endpoints principales

- **GET** `/app/inditex/v1/productPrices` - Obtiene el precio de un producto según fecha, marca y producto.

Ejemplo de petición:
```sh
curl -X GET "http://localhost:8080/app/inditex/v1/productPrices?applicationDate=2020-06-14T10:00:00.000&product=35455&brand=1" -H "accept: application/json"
```

## Pruebas

El servicio cuenta con distintos tipos de pruebas para garantizar su correcto funcionamiento:

- **Pruebas Unitarias**: Verifican el comportamiento de componentes individuales con JUnit y Mockito.
- **Pruebas de Integración**: Comprueban la interacción entre componentes con Spring Boot Test.
- **Pruebas E2E**: Se ejecutan con Rest Assured para validar los endpoints expuestos.
- **Pruebas de Contrato**: Se generan con OpenAPI Generator para garantizar la compatibilidad entre clientes y servicios.

Para ejecutar las pruebas:
```sh
mvn test
```

## Generación del contrato

Se usa OpenAPI para definir y generar la documentación del contrato de la API.

Para generar los contratos:
```sh
mvn clean install
```
El contrato se genera en `target/openapi.yaml` y se puede visualizar con Swagger en:
```
http://localhost:8080/swagger-ui/index.html
```




