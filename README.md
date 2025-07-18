# Spring Boot with Spring Security

A Spring Boot application with REST APIs protected by Spring Security using basic authentication.

## Features

- Spring Boot 2.7.18 with Spring Security
- REST API endpoints with authentication
- In-memory user management
- Basic authentication (no-op password encoding)

## API Endpoints

### Public Endpoints (No Authentication Required)
- `GET /api/public/health` - Health check endpoint

### Protected Endpoints (Authentication Required)
- `GET /api/info` - Information endpoint (requires authentication)

## Default Users

The application comes with two pre-configured users:

1. **User Account:**
   - Username: `user`
   - Password: `password`
   - Role: `USER`

2. **Admin Account:**
   - Username: `admin`
   - Password: `admin123`
   - Role: `USER`, `ADMIN`

**Note:** Passwords are stored using a custom no-op password encoder that doesn't use crypto dependencies.

## Running the Application

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Build and Run
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Testing the APIs

### 1. Test Public Health Endpoint
```bash
curl http://localhost:8080/api/public/health
```

### 2. Test Protected Info Endpoint (without authentication)
```bash
curl http://localhost:8080/api/info
```
This will return a 401 Unauthorized response.

### 3. Test Protected Info Endpoint (with authentication)
```bash
# Using user credentials
curl -u user:password http://localhost:8080/api/info

# Using admin credentials
curl -u admin:admin123 http://localhost:8080/api/info
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           ├── Application.java              # Main application class
│   │           ├── controller/
│   │           │   └── InfoController.java       # REST controller
│   │           └── config/
│   │               └── SecurityConfig.java       # Security configuration
│   └── resources/
│       └── application.properties               # Application properties
└── test/                                        # Test files
```

## Security Configuration

The application uses Spring Security with:
- Basic authentication
- In-memory user management
- Custom no-op password encoder (no crypto dependency)
- Protected API endpoints
- Public health check endpoint

## Customization

To add more users or modify security settings, edit the `SecurityConfig.java` file.

To add more API endpoints, create new controllers or add methods to existing controllers. 