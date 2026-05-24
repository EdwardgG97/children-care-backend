# Children-Care Backend

Backend desarrollado con Spring Boot para la plataforma **Children-Care.com**, orientada a la gestión y administración de información relacionada con el cuidado infantil.

## 📌 Descripción del proyecto

Este proyecto corresponde al desarrollo del backend de la aplicación Children-Care.com. El sistema proporciona una API REST que permite gestionar la información de la plataforma de manera organizada y segura.

El backend fue desarrollado utilizando Spring Boot y una base de datos H2, con el objetivo de mantener una arquitectura sencilla y funcional para fines académicos.

---

# 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Lombok

---

# 📂 Estructura del proyecto

```bash
src/
 ├── main/
 │   ├── java/
 │   │   └── com/childrencare/
 │   │       ├── controller/
 │   │       ├── service/
 │   │       ├── repository/
 │   │       ├── model/
 │   │       └── dto/
 │   └── resources/
 │       ├── application.properties
 │       └── data.sql
 └── test/
```

---

# ⚙️ Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- Java JDK 17 o superior
- Maven 3.9+
- IDE compatible con Spring Boot (IntelliJ IDEA, VS Code o Spring Tool Suite)

---

# 🚀 Instalación y ejecución

## 1. Clonar el repositorio

```bash
git clone https://github.com/usuario/children-care-backend.git
```

## 2. Ingresar al proyecto

```bash
cd children-care-backend
```

## 3. Ejecutar la aplicación

### Con Maven

```bash
mvn spring-boot:run
```

### O ejecutando el archivo principal

Ejecuta la clase:

```bash
ChildrenCareApplication.java
```

---

# 🗄️ Configuración de la base de datos H2

El proyecto utiliza H2 Database en memoria para simplificar la configuración y el despliegue.

## Configuración básica

```properties
spring.datasource.url=jdbc:h2:mem:childrencare
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

---

# 💻 Consola H2

Puedes acceder a la consola de H2 desde:

```text
http://localhost:8080/h2-console
```

## Datos de acceso

| Campo | Valor |
|---|---|
| JDBC URL | jdbc:h2:mem:childrencare |
| User Name | sa |
| Password | (vacío) |

---

# 📡 Endpoints principales

| Método | Endpoint | Descripción |
|---|---|---|
| GET | /api/children | Obtener lista de registros |
| GET | /api/children/{id} | Obtener registro por ID |
| POST | /api/children | Crear nuevo registro |
| PUT | /api/children/{id} | Actualizar registro |
| DELETE | /api/children/{id} | Eliminar registro |

---

# 🧪 Pruebas

Para ejecutar las pruebas del proyecto:

```bash
mvn test
```

---

# 📖 Arquitectura utilizada

El proyecto sigue una arquitectura basada en capas:

- Controller → Manejo de solicitudes HTTP.
- Service → Lógica de negocio.
- Repository → Acceso a datos.
- Model → Entidades y modelos.

Esto permite mantener un código organizado, escalable y fácil de mantener.

---

# 🔒 Buenas prácticas implementadas

- Separación de responsabilidades.
- Uso de DTOs.
- Validaciones básicas.
- Arquitectura REST.
- Uso de JPA para persistencia.
- Configuración centralizada.

---

# 👨‍💻 Autor

Proyecto desarrollado con fines académicos.

**Autor:** Edward Alejandro Garcia Gonzalez

---

# 📄 Licencia

Este proyecto es de uso académico y educativo.

