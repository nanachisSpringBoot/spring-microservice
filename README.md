
# 🧩 Microservices Architecture with Spring Boot

This project is a microservices-based system using **Spring Boot 3**, designed with modularity and scalability in mind. It includes:

- 🧭 **Eureka Discovery Service**
- 🚪 **API Gateway (Spring Cloud Gateway)**
- 🔐 **Auth Service** (JWT-based authentication)
- 👤 **User Service** (with PostgreSQL)
- 📦 **Product Service**
- 🐇 **RabbitMQ** for event-driven communication
- 📘 **Swagger UI** for API documentation

---

## 📁 Project Structure

```
microservices-architecture/
│
├── discovery-service/             # Eureka Discovery Server
│   └── src/
│
├── api-gateway/                   # Gateway for routing and auth filter
│   ├── src/
│   └── application.yml
│
├── auth-service/                  # Handles login, registration, JWT issuing
│   ├── src/
│   └── application.yml
│
├── user-service/                  # User CRUD and event producer
│   ├── src/
│   └── application.yml
│
├── product-service/               # Product catalog and event listener
│   ├── src/
│   └── application.yml
│
├── docker-compose.yml             # Docker services (RabbitMQ, PostgreSQL)
│
├── .gitignore                     # Git ignored files
│
└── README.md                      # Project overview
```

---

## ⚙️ Technologies Used

| Layer          | Technology                            |
|----------------|----------------------------------------|
| Backend        | Spring Boot 3, Spring Cloud            |
| Service Registry | Eureka Discovery                     |
| Routing        | Spring Cloud Gateway                   |
| Security       | Spring Security, JWT                   |
| Messaging      | RabbitMQ                               |
| Database       | PostgreSQL                             |
| Documentation  | Springdoc OpenAPI (Swagger UI)         |
| Containerization | Docker & Docker Compose              |

---

## 🚀 How to Run

### 🐳 Start Services with Docker

```bash
docker-compose up -d
```

This will spin up:
- RabbitMQ (default: `http://localhost:15672`)
- PostgreSQL (for `user-service`)

### 🧱 Build and Run Each Service

Run in each folder:
```bash
./mvnw spring-boot:run
```

Start in this order:

1. `discovery-service`
2. `api-gateway`
3. `auth-service`
4. `user-service`
5. `product-service`

---

## 🔐 Authentication Flow

- `POST /auth/login`  
  - Sends `username/password` → returns JWT

- Use JWT in `Authorization: Bearer <token>` for accessing protected endpoints

---

## 🔁 Event Communication

When a user is created in `user-service`, it publishes an event to RabbitMQ.  
`product-service` listens for this event and processes it accordingly.

---

## 📘 Swagger API Docs

Each microservice exposes Swagger docs:

| Service         | Swagger URL                                     |
|-----------------|--------------------------------------------------|
| API Gateway     | `http://localhost:8080/swagger-ui.html`         |
| Auth Service    | `http://localhost:8080/auth/v3/api-docs`        |
| User Service    | `http://localhost:8080/user/v3/api-docs`        |
| Product Service | `http://localhost:8080/product/v3/api-docs`     |

> Make sure the `springdoc.swagger-ui.urls` in `api-gateway` is properly configured.

---

## 🧹 .gitignore (Recommended)

```gitignore
# Java
target/
*.class
*.jar
*.war

# IDEs
.idea/
*.iml
*.log
.vscode/
*.swp

# OS
.DS_Store
Thumbs.db

# Environment
.env
*.env

# Maven
.mvn/
.mvnw
.mvnw.cmd
```

---

## 📡 Monitoring (optional)

You can later add:
- **Spring Boot Actuator**
- **Prometheus + Grafana**
- **Zipkin or Sleuth** for tracing

---

## 📬 Contact

Built with ❤️ using Spring Boot microservices.  
Open to contributions, feel free to fork & PR.
