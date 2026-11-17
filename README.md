# API de Rentas MDE

Backend municipal para contribuyentes, predios, caja, pagos, arbitrios, alcabala y reportes. Usa Java 17, Spring Boot, SQL Server, JWT y procedimientos almacenados.

## Requisitos

- JDK 17
- SQL Server con el esquema y procedimientos del sistema de rentas
- Variables de entorno descritas en `.env.example`

## Configuración

Defina `DB_HOST`, `DB_NAME`, `DB_USERNAME`, `DB_PASSWORD` y `JWT_SECRET`. La clave JWT debe estar codificada en Base64 y contener al menos 32 bytes. El cifrado de SQL Server se activa por defecto.

## Ejecución

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicación escucha en `http://localhost:8085`. Solo `POST /auth/login` es público. El resto de la API requiere `Authorization: Bearer <token>` y el registro de usuarios exige rol `ADMIN`.

## Documentación API

Con la aplicación iniciada y una sesión autenticada:

- Especificación OpenAPI: `/v3/api-docs`
- Swagger UI: `/swagger-ui/index.html`

## Pruebas y cobertura

```powershell
.\mvnw.cmd test
```

Las pruebas usan H2 en memoria y no acceden al SQL Server real. El reporte JaCoCo se genera en `target/site/jacoco/index.html`.

## Archivos

Los archivos subidos se almacenan en `uploads` por defecto o en la ruta indicada mediante `storage.location`. Esta carpeta contiene datos de ejecución y no se versiona.
