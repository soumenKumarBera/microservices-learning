# 🚀 Microservices Learning

I am currently learning **Microservices Architecture** with Spring Boot and Spring Cloud.

## 📚 Topics I Am Learning

### 1. Eureka Server

* Service Discovery
* Eureka Server setup
* Eureka Client
* Service registration
* Service discovery between microservices
* Connecting multiple services using Eureka

### 2. Microservice-to-Microservice Communication

* One service communicating with another service
* REST API communication
* Service-to-service requests
* Using service names instead of hard-coded URLs
* Understanding how Eureka helps locate services

### 3. Entity Relationships

Learning how to handle relationships between entities across different services.

Examples:

* One entity communicating with another entity
* One-to-One relationship
* One-to-Many relationship
* Handling data when related information exists in another microservice

### 4. Exception Handling

Learning how to handle exceptions properly in microservices.

Topics:

* Global Exception Handling
* `@ControllerAdvice`
* `@ExceptionHandler`
* Custom exceptions
* HTTP status codes
* Handling exceptions from another microservice
* Returning proper error responses

### 5. Service Communication + Exception Handling

Example flow:

```text
User Service
     |
     | Request
     ↓
Order Service
     |
     | Request
     ↓
Product Service
```

If the Product Service is unavailable or the requested product does not exist, the calling service should handle the error properly instead of crashing.

### 🛠️ Technologies

* Java
* Spring Boot
* Spring Cloud
* Eureka Server
* Eureka Client
* REST API
* Maven
* MySQL / MongoDB
* Git & GitHub

## 🎯 Learning Goal

My goal is to understand how multiple Spring Boot applications work together as independent services and how to build reliable communication and exception-handling mechanisms between them.

**Learn → Build → Debug → Improve 🚀**
