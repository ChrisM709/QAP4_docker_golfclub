# Golf Club Tournament API

A Spring Boot REST API for managing golf club tournaments, members, and member-tournament registrations.

---

## 📦 Features

- Create, update, delete golf tournaments
- Register members to tournaments
- Manage member records
- Search for members in a tournament

---

## 🔍 Supported Search APIs

### Get All Members
```http
GET /api/members
```

### Get All Tournaments
```http
GET /api/tournaments
```

### Get All Members in a Tournament
```http
GET /api/tournaments/{id}/members
```

---

## 🐳 How to Run This Project in Docker

### 1. Build the JAR file

```bash
./mvnw clean package
```

This creates a `.jar` file in the `/target` directory.

---

### 2. Run with Docker Compose

```bash
docker-compose up --build
```

This:
- Starts the MySQL database container
- Builds and starts the Spring Boot API container

---

### 3. Access the API

Once running, go to:
- [http://localhost:8080/api/members](http://localhost:8080/api/members)
- [http://localhost:8080/api/tournaments](http://localhost:8080/api/tournaments)
- [http://localhost:8080/api/tournaments/1/members](http://localhost:8080/api/tournaments/1/members)

---

## 🧠 Notes

- MySQL runs inside Docker, mapped to port `3306`
- Spring Boot app runs on port `8080`
- Uses Hibernate JPA to auto-manage schema
