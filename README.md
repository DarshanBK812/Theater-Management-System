# 🎭 Theater Management System – Backend

This is a **Backend REST API** for a **Theater Management System**, built using **Java**, **Spring Boot**, and **MySQL**. It handles various theater operations like managing owners, branches, theaters, employees, movies, tickets, payments, and more. CRUD operations are implemented for each entity. APIs are tested using **Postman**.

---

## 🚀 Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **Postman**

---

## 📁 Project Structure

This project follows a layered architecture:

### 🔹 Controller Layer
- Exposes RESTful endpoints
- Handles incoming HTTP requests and responses

### 🔹 Service Layer
- Contains business logic
- Acts as a bridge between controller and DAO layers

### 🔹 DAO/Repository Layer
- Uses Spring Data JPA to interact with the database
- All entities are connected to their respective repositories

### 🔹 DTO (Data Transfer Object)
- Used for transferring filtered/structured data between layers

### 🔹 Util Package
- For custom **Response Structures**, **Status Codes**, and **Messages**

### 🔹 Exception Handling
- Centralized exception handling using `@ControllerAdvice`
- Custom exceptions for clarity

---

## 🧩 Entities Implemented

- **Owner**
- **Branch**
- **Theater**
- **Manager**
- **Employee**
- **Screen**
- **Food**
- **Ticket**
- **Seat**
- **Payment**
- **Movie**
- **Viewer**

> Each entity supports **CRUD (Create, Read, Update, Delete)** operations.

---

## 📬 API Testing

All endpoints are tested using **Postman**. Each HTTP method (GET, POST, PUT, DELETE) is verified with sample data.

---

## 📌 Note

- ✅ This project **does not include any frontend/UI**.
- ✅ Fully focused on **backend development** and RESTful API design.
- ✅ Modular, clean, and layered architecture suitable for real-time expansion.

---

## 🧠 Future Scope

- Integration with frontend using React or Angular
- Authentication and Authorization (e.g., using Spring Security, JWT)
- Role-based access for Admin, Manager, Viewer
- Enhanced reporting and analytics modules

---

## 🤝 Contributions

Pull requests and suggestions are welcome! If you find any issues or improvements, feel free to raise them.

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 👤 Developed By

**Darshan B K**  
[LinkedIn](https://www.linkedin.com/in/darshan-b-k-a7b501298) | [GitHub](https://github.com/YourGitHubUsername)

