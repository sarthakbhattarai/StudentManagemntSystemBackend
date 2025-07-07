# Student Management System Backend

A Spring Boot application for the Student Management System, exposing RESTful APIs secured with JWT and managing data via PostgreSQL.

## Table of Contents

* [Features](#features)
* [Prerequisites](#prerequisites)
* [Getting Started](#getting-started)
* [Configuration](#configuration)
* [Project Structure](#project-structure)
* [Running the Application](#running-the-application)
* [API Endpoints](#api-endpoints)
* [Contributing](#contributing)
* [License](#license)

## Features

* **Authentication & Authorization**: JWT-based login/logout with roles (ADMIN, TEACHER, STUDENT).
* **CRUD Operations**: Manage Students, Teachers, Departments, Programs, Courses, Sections, Enrollments, Attendance, Grades, Invoices, Payments, Scholarships.
* **Database Migrations**: Flyway-managed versioned migrations in `db/migration`.
* **Monitoring & Health**: Spring Boot Actuator endpoints for health checks, metrics, and environment.
* **Validation**: JSR-303 bean validation on incoming payloads.

## Prerequisites

* Java 17 or higher
* Maven 3.6+ (or Gradle if preferred)
* PostgreSQL database

## Getting Started

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-org/student-mgmt-backend.git
   cd student-mgmt-backend
   ```

2. **Build the project**

   ```bash
   mvn clean package
   ```

3. **Configure database and JWT** in `application.properties` (see below).

4. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

## Configuration

Edit **`src/main/resources/application.properties`** with your environment values:

```properties
# Server
server.port=8080

# Datasource (PostgreSQL)
spring.datasource.url=jdbc:postgresql://localhost:5432/sms_db
spring.datasource.username=sms_user
spring.datasource.password=sms_password

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Flyway Migrations
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

# Security / JWT
jwt.secret=ReplaceWithASecureSecretKey
jwt.expiration-ms=3600000

# Actuator
management.endpoints.web.exposure.include=health,info,metrics,env

# Logging
logging.level.org.springframework=INFO
logging.level.com.yourorg.sms=DEBUG
```

## Project Structure

```
student-mgmt-backend/
├── src/
│   ├── main/
│   │   ├── java/com/yourorg/sms/
│   │   │   ├── config/          # Security, CORS, Swagger
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── dto/             # Request/response DTOs
│   │   │   ├── entity/          # JPA entities
│   │   │   ├── exception/       # Custom exceptions & handlers
│   │   │   ├── repository/      # Spring Data JPA repositories
│   │   │   ├── security/        # JWT filters, UserDetailsService
│   │   │   ├── service/         # Business logic services
│   │   │   └── StudentMgmtApplication.java
│   └── resources/
│       ├── application.properties
│       └── db/migration/        # Flyway SQL scripts
└── pom.xml
```

## Running the Application

* **Development**: `mvn spring-boot:run`
* **Production build**: `mvn clean package` then run the resulting JAR:

  ```bash
  java -jar target/student-mgmt-backend-0.0.1-SNAPSHOT.jar
  ```

## API Endpoints

| Method | Path                 | Description                  |
| ------ | -------------------- | ---------------------------- |
| POST   | `/api/auth/login`    | Authenticate and receive JWT |
| GET    | `/api/students`      | List all students            |
| POST   | `/api/students`      | Create a new student         |
| PUT    | `/api/students/{id}` | Update student details       |
| DELETE | `/api/students/{id}` | Remove a student             |
| GET    | `/api/courses`       | List all courses             |
| …      | …                    | …                            |

## Contributing

Pull requests, issues, and feature requests are welcome! Please follow the existing code style and include tests for new functionality.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
