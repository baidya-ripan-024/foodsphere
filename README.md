# FoodSphere - Online Food Ordering WebApp 🍽️

<p align="center">
  <em>A full-stack, scalable food ordering web application designed to seamlessly connect restaurants and customers.</em>
</p>

<p align="center">
  <a href="https://github.com/baidya-ripan-024/foodsphere/stargazers"><img src="https://img.shields.io/github/stars/[your-github-username]/foodsphere?style=for-the-badge&logo=github&color=FFC107" alt="Stars"></a>
  <a href="https://github.com/baidya-ripan-024/foodsphere/network/members"><img src="https://img.shields.io/github/forks/[your-github-username]/foodsphere?style=for-the-badge&logo=github&color=8BC34A" alt="Forks"></a>
  <a href="https://github.com/baidya-ripan-024/foodsphere/issues"><img src="https://img.shields.io/github/issues/[your-github-username]/foodsphere?style=for-the-badge&logo=github&color=FF5722" alt="Issues"></a>
  <a href="https://github.com/baidya-ripan-024/foodsphere/blob/main/LICENSE"><img src="https://img.shields.io/github/license/[your-github-username]/foodsphere?style=for-the-badge&color=03A9F4" alt="License"></a>
</p>


## ✨ Overview

Welcome to **FoodSphere**! This is a comprehensive, role-based online food ordering platform built with a modern tech stack including **Java**, **Spring Boot**, and **React**. The project provides a seamless and secure experience for all stakeholders: customers who want to order food, restaurant owners who need to manage their business, and administrators who oversee the platform's operations.

The application features secure authentication, real-time order tracking, dynamic menu management, and an integrated payment system, all deployed on a scalable cloud infrastructure.

**Live Website:** [**www.foodsphere-demo.com**](https://www.foodsphere-demo.com) 🚀



## 🚀 Key Features

### 👤 Customer Features
-   🔐 **Secure Authentication**: Easy sign-up and login with JWT-based secure sessions.
-   🍔 **Interactive Menu Browse**: Explore restaurants, view detailed menus, and search for favorite dishes.
-   🛒 **Dynamic Shopping Cart**: Add items to the cart, see real-time price updates, and enjoy a smooth checkout process.
-   📦 **Order Placement & Tracking**: Place orders seamlessly and track their status from "placed" to "delivered."
-   📜 **Order History**: Access a detailed history of all past orders for easy reordering.

### 🏪 Restaurant Owner Features
-   🏗️ **Restaurant Management**: Create and customize restaurant profiles with names, descriptions, and images.
-   📝 **Dynamic Menu Control**: Easily add, update, or remove menu items and manage their availability in real-time.
-   📊 **Order Dashboard**: A dedicated dashboard to track incoming orders, update their statuses, and manage restaurant operations.
-   🥗 **Ingredient Management**: Define and categorize ingredients for menu items.

### 🛡️ Administrator Features
-   ⚙️ **Centralized Admin Panel**: A powerful dashboard to oversee the entire platform.
-   🧑‍⚖️ **User & Restaurant Management**: Manage all user accounts and restaurant listings, with capabilities to approve, suspend, or delete.
-   📈 **Platform-Wide Order Monitoring**: Track all orders, manage delivery statuses, and resolve any issues.

### 💳 Secure Payment Integration
-   💸 **Stripe Payment Gateway**: Integrated with **Stripe** for secure, reliable, and PCI-compliant online payment processing.



## 🛠️ Architecture & Tech Stack

### Technologies Used

| Category | Technology |
|---|---|
| **Frontend** | ![React](https://img.shields.io/badge/React-18-61DAFB?style=for-the-badge&logo=react) ![TailwindCSS](https://img.shields.io/badge/Tailwind_CSS-3-38B2AC?style=for-the-badge&logo=tailwind-css) ![Axios](https://img.shields.io/badge/Axios-1.x-5A29E4?style=for-the-badge&logo=axios) |
| **Backend** | ![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring) ![Spring Security](https://img.shields.io/badge/Spring_Security-6-6DB33F?style=for-the-badge) |
| **Database**| ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-4169E1?style=for-the-badge&logo=postgresql&logoColor=white) ![JPA](https://img.shields.io/badge/Spring_Data_JPA-3.x-6DB33F?style=for-the-badge) |
| **Payments** | ![Stripe](https://img.shields.io/badge/Stripe-API-6772E5?style=for-the-badge&logo=stripe&logoColor=white) |
| **Deployment**| ![AWS](https://img.shields.io/badge/AWS-Cloud-232F3E?style=for-the-badge&logo=amazon-aws) ![Docker](https://img.shields.io/badge/Docker-20.10-2496ED?style=for-the-badge&logo=docker&logoColor=white) |


### 📊 Class Diagram

This diagram illustrates the core entities and their relationships within the backend system.

![Class Diagram](https://github.com/user-attachments/assets/09b5942b-b234-4568-84c3-535a22be83f2)



## 💻 Local Setup & Installation

To get a local copy up and running, follow these steps.

### Prerequisites
-   Java JDK 17+
-   Apache Maven 3.8+
-   PostgreSQL Server
-   Node.js and npm
-   Your favorite IDE (e.g., IntelliJ IDEA, VSCode)

### Backend Setup (Spring Boot)
1.  **Clone the repository:**
    ```bash
    git clone https://github.com/baidya-ripan-024/foodsphere.git
    cd foodsphere/backend
    ```
2.  **Configure Database:**
    Open `src/main/resources/application.properties` and update the PostgreSQL connection details:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/foodsphere_db
    spring.datasource.username=your_postgres_user
    spring.datasource.password=your_postgres_password
    ```
3.  **Configure JWT & Stripe:**
    Add your JWT secret and Stripe API keys to the same `application.properties` file:
    ```properties
    jwt.secret=your_super_secret_jwt_key
    stripe.api.key=your_stripe_api_secret_key
    ```
4.  **Build and Run:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
    The backend server will start on `http://localhost:8080`.

### Frontend Setup (React)
1.  **Navigate to the frontend directory:**
    ```bash
    cd ../frontend
    ```
2.  **Install dependencies:**
    ```bash
    npm install
    ```
3.  **Configure API Endpoint:**
    Create a `.env` file in the `frontend` directory and add the backend API URL:
    ```env
    REACT_APP_API_BASE_URL=http://localhost:8080
    ```
4.  **Run the application:**
    ```bash
    npm start
    ```
    The React development server will open at `http://localhost:3000`.

## 🤝 Contributing

Contributions make the open-source community an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**. Please fork the repo and create a pull request.


## 📄 License

This project is distributed under the MIT License. See `LICENSE` for more information.


## 📬 Contact

Ripan Baidya - [baidya.ripan.024@gmail.com](mailto:baidya.ripan.024@gmail.com)

Project Link: [https://github.com/baidya-ripan-024/foodsphere](https://github.com/baidya-ripan-024/foodsphere)
