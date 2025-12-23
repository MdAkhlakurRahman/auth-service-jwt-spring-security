# 🔐 User Authentication & Authorization Service

A **stateless authentication and authorization backend** built using **Spring Boot** and **Spring Security**, implementing **JWT-based security** and **role-based access control (RBAC)**.

🔗 **GitHub Repo**: https://github.com/MdAkhlakurRahman/auth-service-jwt-spring-security

---

## 🚀 Features

- JWT-based **stateless authentication**
- **Spring Security 6** configuration (no sessions, no form login)
- **Role-Based Access Control (RBAC)** with multiple roles
- Secure password storage using **BCrypt**
- Custom JWT filter integrated into Spring Security filter chain
- MySQL-backed persistence using **Spring Data JPA**
- Clean layered architecture (Controller, Service, Repository)

---

## 🛠 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Security 6**
- **JWT (jjwt)**
- **Spring Data JPA**
- **MySQL**
- **Maven**

---

## 📂 Project Structure

```

controller   → REST APIs (login, test endpoints)
service      → Business logic & UserDetailsService
security     → JWT, filters, security configuration
entity       → User & Role entities
repository   → JPA repositories

```

---

## 🔐 Authentication Flow

1. User logs in with username & password  
2. Credentials validated via Spring Security  
3. JWT token generated and returned  
4. Client sends JWT in `Authorization: Bearer <token>` header  
5. JWT filter validates token on every request  

---

## 🧪 API Endpoints

### Login
```

POST /api/auth/login

````
```json
{
  "username": "testuser",
  "password": "password"
}
````

### Protected API (JWT required)

```
GET /api/test/hello
Authorization: Bearer <JWT_TOKEN>
```

---

## 🧠 Key Learnings

* Difference between **401 Unauthorized** and **403 Forbidden**
* Stateless security using JWT
* Spring Security filter chain customization
* Proper RBAC design with JPA relationships

---

## 📌 Future Enhancements

* User Registration API
* Role-based endpoint authorization (`@PreAuthorize`)
* Global exception handling
* Refresh tokens
* Dockerization

---

## 👤 Author

Md Akhlakur Rahman — Backend Developer (Java | Spring Boot)
