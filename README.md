# 🍽️ FoodSphere - Online Food Ordering WebApp

Welcome to **FoodSphere**, a full-featured, role-based online food ordering application built using **Spring Boot**. 
This project provides a seamless and secure experience for both **users** and **administrators**, allowing users to order food, manage restaurants, and handle payments efficiently.


## 📌 Overview

**FoodSphere** is a modern web application built with **Spring Boot** and a secure, scalable architecture. It supports:

- 👥 User and Admin roles
- 🛒 Cart and order management
- 🍴 Restaurant creation and customization
- 💳 Stripe payment integration
- 🔐 Secure authentication with JWT



## 🛠️ Tech Stack

| Technology          |  Purpose                               |
|---------------------|----------------------------------------|
| ⚙️ Spring Boot     | Core backend framework                 |
| 🔐 Spring Security | JWT-based authentication and security  |
| 🗃️ Spring Data JPA | ORM and database access with MySQL     |
| 🐘 PostgreSql      | Relational database for data storage   |
| 📬 Postman         | API testing and debugging              |
| 💸 Stripe          | Secure online payment integration      |
| ☁️ Vercel, AWS     | Deploying Frontend & Backend            |


## 🚀 Features

### 👤 User Features
- 📝 **Registration & Login** – Secure signup and JWT-based login.
- 🍔 **Browse & Order** – Discover restaurants and order food.
- 🛒 **Cart Management** – Add, view, update, or remove cart items.
- 📦 **Order History** – Track past and active orders.

### 🏪 Restaurant Owner Features
- 🏗️ **Create Restaurant** – Setup a restaurant with menu and details.
- 🖼️ **Upload Images** – Showcase restaurant and food visually.
- 🧂 **Ingredient Management** – Add or update ingredients for dishes.

### 🛡️ Admin Features
- 📋 **Monitor Orders** – View and manage all placed orders.
- 🛠️ **Manage Restaurants** – Update or disable restaurants as needed.
- 🧑‍⚖️ **Operational Controls** – Approve, suspend, or close listings.

### 💳 Payment Integration
- ✅ Integrated with **Stripe** for secure and seamless payments.


## 📊 Class Diagram

![Class Diagram](https://github.com/user-attachments/assets/09b5942b-b234-4568-84c3-535a22be83f2)


## 🧪 API Testing with Postman

- All endpoints are documented and tested using **Postman**.
- Use the `/auth/login` endpoint to retrieve JWT for authorized requests.


## 💻 Setup & Run

### Prerequisites:
- Java 17+
- Maven
- PostgreSql
- Your favourite IDE

### Steps:

```bash
# Clone the repository
git clone https://github.com/baidya-ripan-024/foodsphere.git

# Configure PostgreSql credentials in application.yml

# Build and run
mvn spring-boot:run
