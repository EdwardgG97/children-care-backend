# Children-Care Backend

Backend desarrollado con Spring Boot para la plataforma **Children-Care.com**, una plataforma web informativa enfocada en alfabetización digital y seguridad en internet para niños y padres de familia en Colombia, tomando como referencia la Ley 2489 de 2025 sobre entornos digitales seguros para menores.

## 📌 Descripción del proyecto

Este proyecto corresponde al desarrollo del backend de la aplicación Children-Care.com. El sistema proporciona una API REST que permite gestionar artículos educativos sobre seguridad digital, ciberacoso, privacidad en internet, redes sociales, buenas prácticas digitales y consejos para padres.

El backend fue desarrollado utilizando Spring Boot y una base de datos H2, con el objetivo de mantener una arquitectura sencilla, limpia y funcional para fines académicos.

---

# 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot 4.0.6
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Lombok
- Validation
- Spring Boot DevTools

---

# 📂 Estructura del proyecto

```bash
src/
 ├── main/
 │   ├── java/
 │   │   └── com/childrencare/
 │   │       ├── controller/      # Controladores REST (endpoints)
 │   │       ├── service/         # Lógica de negocio
 │   │       ├── repository/      # Acceso a datos (JPA)
 │   │       ├── entity/          # Entidades de base de datos
 │   │       ├── dto/             # Data Transfer Objects
 │   │       ├── config/          # Configuraciones (CORS, excepciones)
 │   │       └── ChildrenCareApplication.java  # Clase principal
 │   └── resources/
 │       └── application.properties
 └── test/
```

### Explicación de cada capa

- **Entity**: Representa una tabla en la base de datos. Define la estructura de los datos.
- **DTO**: Objetos utilizados para transferir datos entre el frontend y el backend.
- **Repository**: Interfaz que extiende JpaRepository para operaciones CRUD básicas.
- **Service**: Contiene la lógica de negocio. Transforma entidades a DTOs y viceversa.
- **Controller**: Expone los endpoints REST. Recibe peticiones HTTP y devuelve respuestas.
- **Config**: Configuraciones globales de la aplicación (CORS, manejo de excepciones).

---

# ⚙️ Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- Java JDK 17 o superior
- Maven 3.9+ (o usar el wrapper incluido)
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

### Con Maven wrapper (recomendado)

```bash
# En Windows
mvnw.cmd spring-boot:run

# En Linux/Mac
./mvnw spring-boot:run
```

### Con Maven instalado

```bash
mvn spring-boot:run
```

### O ejecutando el archivo principal

Ejecuta la clase `ChildrenCareApplication.java` desde tu IDE.

---

# 🗄️ Configuración de la base de datos H2

El proyecto utiliza H2 Database en archivo (persistente) para simplificar la configuración y el despliegue.

## Configuración en application.properties

```properties
# Base de datos en archivo (persistente)
spring.datasource.url=jdbc:h2:file:./data/childrencare_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Consola H2 habilitada
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA configurado para actualizar el esquema automáticamente
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
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
| JDBC URL | jdbc:h2:file:./data/childrencare_db |
| User Name | sa |
| Password | (vacío) |

---

# 📡 Endpoints de la API

### Base URL
```
http://localhost:8080/api/articles
```

| Método | Endpoint | Descripción |
|---|---|---|
| GET | /api/articles | Obtener todos los artículos |
| GET | /api/articles/{id} | Obtener artículo por ID |
| POST | /api/articles | Crear nuevo artículo |
| PUT | /api/articles/{id} | Actualizar artículo |
| DELETE | /api/articles/{id} | Eliminar artículo |
| GET | /api/articles/category/{category} | Buscar artículos por categoría |
| GET | /api/articles/search?title={texto} | Buscar artículos por título |

## Ejemplos de peticiones

### Crear un artículo (POST)

```json
{
  "title": "Seguridad Digital para Niños",
  "summary": "Guía básica sobre seguridad digital",
  "content": "El contenido completo del artículo...",
  "category": "Seguridad Digital",
  "imageUrl": "https://example.com/image.jpg"
}
```

### Respuesta de artículo

```json
{
  "id": 1,
  "title": "Seguridad Digital para Niños",
  "summary": "Guía básica sobre seguridad digital",
  "content": "El contenido completo del artículo...",
  "category": "Seguridad Digital",
  "imageUrl": "https://example.com/image.jpg",
  "createdAt": "2025-01-15T10:30:00"
}
```

## Ejemplo de uso con JavaScript (Fetch API)

```javascript
// Obtener todos los artículos
fetch('http://localhost:8080/api/articles')
  .then(response => response.json())
  .then(data => console.log(data));

// Crear un nuevo artículo
const newArticle = {
  title: "Privacidad en Redes Sociales",
  summary: "Aprende a proteger tu privacidad",
  content: "Contenido completo...",
  category: "Privacidad",
  imageUrl: "https://example.com/privacy.jpg"
};

fetch('http://localhost:8080/api/articles', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(newArticle)
})
  .then(response => response.json())
  .then(data => console.log(data));
```

---

# 🧪 Pruebas

Para ejecutar las pruebas del proyecto:

```bash
mvn test
```

---

# 📖 Arquitectura utilizada

El proyecto sigue una arquitectura basada en capas:

- **Controller** → Manejo de solicitudes HTTP y respuestas REST.
- **Service** → Lógica de negocio y transformación de datos.
- **Repository** → Acceso a datos mediante JPA.
- **Entity** → Entidades que representan tablas de la base de datos.
- **DTO** → Objetos de transferencia de datos para la API.
- **Config** → Configuraciones globales (CORS, manejo de excepciones).

Esto permite mantener un código organizado, escalable y fácil de mantener.

---

# 🔒 Buenas prácticas implementadas

- Separación de responsabilidades en capas.
- Uso de DTOs para separar entidades de la API.
- Validaciones con anotaciones (@NotBlank, @Size).
- Manejo centralizado de excepciones con @RestControllerAdvice.
- Configuración de CORS para permitir peticiones cross-origin.
- Inyección de dependencias mediante constructor.
- Código comentado con JavaDoc.
- Uso de Lombok para reducir código repetitivo.
- Respuestas HTTP con códigos de estado apropiados.
- Configuración externa en application.properties.

---

# 📚 Categorías sugeridas para artículos

- Seguridad Digital
- Ciberacoso
- Privacidad en Internet
- Redes Sociales
- Buenas Prácticas Digitales
- Consejos para Padres
- Protección de Datos
- Navegación Segura
- Identidad Digital
- Phishing y Estafas

---

# 👨‍💻 Autor

Proyecto desarrollado con fines académicos.

**Autor:** Edward Alejandro Garcia Gonzalez

---

# 📄 Licencia

Este proyecto es de uso académico y educativo.

