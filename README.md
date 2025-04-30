# Expense Tracker Application

A simple web-based Expense Tracker built using Spring Boot, Thymeleaf, and MySQL. This application allows users to register, log in, and manage their personal expenses.

## 🚀 Features

- User Registration and Login
- Session-based Authentication
- Add, Edit, View, and Delete Expenses
- Secure per-user data access
- Built with Bootstrap for responsive UI

## 🛠 Technologies Used

- Java
- Spring Boot
- Spring MVC
- Thymeleaf
- MySQL
- Hibernate (Spring Data JPA)
- HTML, CSS (Bootstrap)
- Git & GitHub

## 💾 Database Configuration

Make sure to configure your `application.properties` (or `application.yml`) with correct database credentials.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
