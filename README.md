# 🚀 User Management System (Hibernate + JPA)

A backend project built using **Java, Hibernate (JPA), and MySQL** that demonstrates complete user management with CRUD operations, authentication, and advanced database queries.

---

## 📌 Project Overview

This project simulates a real-world **User Management System** where users can be created, updated, deleted, verified, and retrieved using multiple search criteria.
It focuses on understanding **ORM (Object Relational Mapping)** and efficient database interaction using Hibernate.

---

## 🔧 Features

* ✅ Create (Save) User
* ✅ Update User Details
* ✅ Delete User by ID
* ✅ Find User by ID, Phone, Email
* ✅ Verify User (Phone/Email/ID + Password)
* ✅ Search Users by Name
* ✅ Fetch All Users
* ✅ Fetch All Emails & Phone Numbers using HQL

---

## 🛠 Tech Stack

* **Java**
* **Hibernate (JPA)**
* **MySQL**
* **Maven**

---

## 📁 Project Structure

```
hibernate-user-crud-project/
│
├── src/main/java/com/org/jpa/hibernateProject1/
│   ├── HibernateUtil.java      # Hibernate configuration
│   ├── User.java               # Entity class
│   ├── UserDao.java            # Database operations (DAO layer)
│   ├── UserController.java     # Menu-driven application
│
├── src/main/resources/
│   └── hibernate.cfg.xml       # Hibernate configuration file
│
├── pom.xml                     # Dependencies
└── README.md
```

---

## ▶️ How to Run

1. Clone the repository
2. Create a MySQL database (e.g., `employeedb`)
3. Update DB credentials in `hibernate.cfg.xml`
4. Run `UserController.java`
5. Use the console menu to perform operations

---

## 💡 Key Learnings

* Hibernate ORM and entity mapping
* Session and transaction management
* Writing HQL queries
* Backend architecture (DAO pattern)
* Real-world CRUD and authentication logic

---

## 🎥 Demo

A demo video is included showcasing all operations and project flow.

---

## 🔗 GitHub Repository

https://github.com/vinay21165/User_CRUD_Hibernate-JPA-Project

---

## 📈 Future Enhancements

* Convert to **Spring Boot REST API**
* Add **JWT Authentication**
* Implement **Exception Handling & Logging**


---

## 🙌 Feedback

I would love your feedback and suggestions to improve this project.

---

### ⭐ If you found this project helpful, consider giving it a star!
