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

* Connecting one entity to another entity
* One-to-One relationship
* One-to-Many relationship
* Handling related data between microservices

### 4. Exception Handling

* Global Exception Handling
* `@ControllerAdvice`
* `@ExceptionHandler`
* Custom exceptions
* HTTP status codes
* Handling exceptions from another microservice
* Returning proper error responses

### 5. API Gateway

Currently learning **API Gateway** with Spring Cloud Gateway.

Topics:

* API Gateway setup
* Routing requests to different microservices
* Route configuration
* Gateway filters
* Request and response handling
* Path-based routing
* Service discovery with Eureka
* Centralized entry point for microservices
* Understanding how API Gateway communicates with Eureka

Example:

```text
                    ┌───────────────┐
                    │   API Gateway │
                    └───────┬───────┘
                            │
             ┌──────────────┼──────────────┐
             ↓              ↓              ↓
        User Service   Order Service   Product Service
             │              │              │
             └──────────────┼──────────────┘
                            ↓
                     Eureka Server
```

### 6. Service Communication + Exception Handling

Learning how services communicate with each other and how failures are handled properly.

```text
Client
  ↓
API Gateway
  ↓
User Service
  ↓
Order Service
  ↓
Product Service
```

## 🛠️ Technologies

* Java
* Spring Boot
* Spring Cloud
* Spring Cloud Gateway
* Eureka Server
* Eureka Client
* REST API
* Maven
* MySQL / MongoDB
* Git & GitHub

## 🎯 Learning Goal

My goal is to understand how multiple Spring Boot applications work together as independent services and build reliable communication, API Gateway routing, service discovery, and exception-handling mechanisms.

**Learn → Build → Debug → Improve 🚀**
