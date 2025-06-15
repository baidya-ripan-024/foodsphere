# 📡 API Testing Guide for FoodSphere

This document outlines the full set of API endpoints used in the **FoodSphere Food Ordering Application**. These endpoints were thoroughly tested using tools like **Postman**. Each example is designed to reflect real-world use cases.


## 1. 🧾 Signup

**Endpoint:** `POST http://localhost:8000/auth/signup`

### 🔸 Examples:

#### a. Customer User - John Doe

```json
{
  "fullName": "John Doe",
  "email": "john.doe@example.com",
  "password": "password123",
  "role": "ROLE_CUSTOMER",
  "favourites": [],
  "addresses": [
    {
      "streetAddress": "123 Main St",
      "city": "New York",
      "country": "USA",
      "postalCode": "10001"
    }
  ]
}
```

#### b. Customer User - Jane Smith

```json
{
  "fullName": "Jane Smith",
  "email": "jane.smith@example.com",
  "password": "secure456",
  "role": "ROLE_CUSTOMER",
  "favourites": [],
  "addresses": [
    {
      "streetAddress": "456 Maple Avenue",
      "city": "Los Angeles",
      "country": "USA",
      "postalCode": "90001"
    }
  ]
}
```

#### c. Customer User - Rahul Verma

```json
{
  "fullName": "Rahul Verma",
  "email": "rahul.verma@example.com",
  "password": "rahulPass789",
  "role": "ROLE_CUSTOMER",
  "favourites": [],
  "addresses": []
}
```

#### d. Admin User - Admin Boss

```json
{
  "fullName": "Admin Boss",
  "email": "admin@example.com",
  "password": "adminSecure@123",
  "role": "ROLE_ADMIN",
  "favourites": [],
  "addresses": [
    {
      "streetAddress": "789 Corporate Blvd",
      "city": "San Francisco",
      "country": "USA",
      "postalCode": "94105"
    }
  ]
}
```

#### e. Restaurant Owner - Ramesh Chef

```json
{
  "fullName": "Ramesh Chef",
  "email": "ramesh.chef@foodhub.com",
  "password": "chefSpecial123",
  "role": "ROLE_RESTAURANT_OWNER",
  "favourites": [],
  "addresses": [
    {
      "streetAddress": "99 Food Street",
      "city": "Mumbai",
      "country": "India",
      "postalCode": "400001"
    }
  ]
}
```


## 2. 🔐 Signin

**Endpoint:** `POST http://localhost:8000/auth/signin`

### 🔸 Examples:

#### a. Restaurant Owner - Ramesh Chef

```json
{
  "email": "ramesh.chef@foodhub.com",
  "password": "chefSpecial123"
}
```

#### b. Admin User - Admin Boss

```json
{
  "email": "admin@example.com",
  "password": "adminSecure@123"
}
```

#### c. Customer User - John Doe

```json
{
  "email": "john.doe@example.com",
  "password": "password123"
}
```


## 3. 🍴 Restaurant Endpoints

* **Create Restaurant:** `POST /api/admin/restaurants`
* **Update Restaurant:** `PUT /api/admin/restaurants/{restaurantId}`
* **Delete Restaurant:** `DELETE /api/admin/restaurants/{restaurantId}`
* **Update Restaurant Status:** `PUT /api/admin/restaurants/{restaurantId}/status`
* **Get Restaurant by Owner:** `GET /api/admin/restaurants/user`
* **Add to Favourites:** `PUT /api/restaurants/{restaurantId}/add-favourites`
* **Get All Restaurants:** `GET /api/restaurants`
* **Get Restaurant by ID:** `GET /api/restaurants/{restaurantId}`
* **Search Restaurant:** `GET /api/restaurants/search?keyword={searchquery}`


## 4. 🗂️ Category Endpoints

* **Create Category:** `POST /api/category/create`
* **Get Category by ID:** `GET /api/category/{categoryId}`
* **Get All Categories for Restaurant:** `GET /api/category/restaurant`


## 5. 🌿 Ingredients Category Endpoints

* **Create Ingredient Category:** `POST /api/admin/ingredients/category/create`
* **Create Ingredient Items:** `POST /api/admin/ingredients/items/create`
* **Get All Ingredients by Restaurant ID:** `GET /api/admin/ingredients/restaurant/restaurantId`
* **Get Categories by Restaurant:** `GET /api/admin/ingredients/restaurant/restaurantId/category`
* **Toggle Stock Status:** `PUT /api/admin/ingredients/stock/{id}`


## 6. 🍽️ Food Endpoints

* **Create Food:** `POST /api/admin/foods/create`
* **Update Food Availability:** `PUT /api/admin/foods/{id}`
* **Delete Food:** `DELETE /api/admin/foods/{id}`


## 7. 🛒 Cart Endpoints

* **Add to Cart:** `POST /api/cart/add`
* **Update Cart Item:** `PUT /api/cart-item/update`
* **Get Cart Items:** `GET /api/cart`
* **Clear Cart:** `DELETE /api/cart/clear`
* **Remove Cart Item:** `DELETE /api/cart-item/{id}/remove`


## 8. 📦 Order Endpoints

* **Place Order:** `POST /api/order`
* **Get User Orders:** `GET /api/order/user`
* **Delete Order:** `DELETE /api/order/{id}`
* **Update Order Status:** `PUT /api/admin/order/2/DELIVERED`
* **Get Restaurant Orders:** `GET /api/admin/order/restaurant/2`


> ⚠️ **Note:** Replace `{{BASE_URL}}` with `http://localhost:8000` or your production API base URL.

This document serves as a reference for API testing, ensuring that endpoints are correctly invoked with appropriate payloads. It is essential for backend verification and frontend integration.
