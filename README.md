# 🚗 Car Rental System

A complete desktop-based Car Rental Management System developed using Java and MySQL.  
This project was designed to manage car rental operations efficiently through a modern graphical user interface built with Java Swing.

---

# 📌 Project Overview

The Car Rental System helps rental companies manage:

- Customers
- Cars
- Rentals
- Payments
- Maintenance
- Expenses
- Reports
- Employees

The system follows a layered architecture using:

- MVC Design Pattern
- DAO Pattern
- Service Layer

---

# 🛠 Technologies Used

| Technology | Description |
|------------|-------------|
| Java | Core Programming Language |
| Java Swing | GUI Development |
| MySQL | Database Management |
| JDBC | Database Connectivity |
| Git & GitHub | Version Control |

---

# 📂 Project Structure

```text
src/
│
├── controller/
├── dao/
├── model/
├── service/
├── util/
├── view/
├── database/
└── image/
```

---

# 🧩 Main Packages Description

## 📦 model
Contains all system entities and data models.

Examples:
- Car
- Customer
- RentalContract
- Payment
- Employee

---

## 📦 dao
Responsible for database operations.

Examples:
- CarDAO
- CustomerDAO
- RentalDAO

---

## 📦 service
Contains business logic and system operations.

Examples:
- CarService
- RentalService
- PaymentService

---

## 📦 controller
Acts as a connection between GUI and services.

Examples:
- CarController
- RentalController
- PaymentController

---

## 📦 view
Contains all graphical user interfaces.

Examples:
- Dashboard
- LoginScreen
- RentalForm
- ReportsUI

---

## 📦 util
Contains helper classes and utilities.

Examples:
- DBConnection
- ValidationUtils
- PasswordHasher

---

# ✨ System Features

## 🚘 Car Management
- Add cars
- Update cars
- Delete cars
- View available cars

## 👤 Customer Management
- Add customers
- Edit customer information
- Delete customers

## 📄 Rental Management
- Create rental contracts
- Return rented cars
- Calculate rental costs

## 💳 Payment System
- Manage payments
- Store payment records

## 🛠 Maintenance Management
- Track vehicle maintenance
- Record maintenance expenses

## 📊 Reports Dashboard
- Rental reports
- Payment reports
- Customer reports
- Car reports

## 🔐 Authentication System
- User login system
- Password protection

---

# 🗄 Database Setup

## Step 1
Open phpMyAdmin.

## Step 2
Create a database named:

```sql
carrentalsystem
```

## Step 3
Import the database file located in:

```text
src/database/carrentalsystem.sql
```

---

# ▶️ How to Run the Project

## Requirements
- Java JDK 17 or later
- MySQL Server
- IDE (Eclipse / IntelliJ / VS Code)

---

## Steps

1. Clone the repository:

```bash
git clone https://github.com/NadeemMansour/Car-Rental-System.git
```

2. Open the project in your IDE.

3. Add MySQL Connector JAR file.

4. Configure database connection inside:

```text
DBConnection.java
```

5. Run:

```text
MainApp.java
```

---

# 📸 User Interfaces

The project includes modern interfaces such as:

- Login Screen
- Dashboard
- Car Management
- Rental Management
- Reports System

---

# 📈 Design Patterns Used

- MVC Pattern
- DAO Pattern
- Layered Architecture

---

# 🔒 Security

- Password hashing
- Input validation
- Database validation

---

# 👨‍💻 Authors

## Nadeem Mansour

Software Engineering Student

---

# 📄 License

This project is developed for educational purposes.

---

# ⭐ GitHub Repository

Repository Link:

https://github.com/NadeemMansour/Car-Rental-System
