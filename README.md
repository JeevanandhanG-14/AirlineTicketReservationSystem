# ✈️ Airline Ticket Reservation System

A console-based **Java** project that simulates an airline ticket booking system.  
It allows users to **book, view, update, and cancel tickets**. The project uses **JDBC** for database connectivity and **MySQL** as the backend.  

---

## 🚀 Features
- Book a flight ticket with passenger details  
- View booked tickets using mobile number  
- Update journey date for existing bookings  
- Cancel bookings  
- Persistent storage with MySQL  

---

## 🛠️ Tech Stack
- **Language**: Java (Core + OOPs)  
- **Database**: MySQL  
- **Connectivity**: JDBC  
- **IDE**: Eclipse / IntelliJ IDEA  

---

## 📂 Project Structure

Airline-Ticket-Reservation-System/
├── src/com/project/
│ ├── AirlinesApplication.java # Main application
│ ├── AirIndia.java # AirIndia airline logic
│ ├── AirAsia.java # AirAsia airline logic
│ ├── Indigo.java # Indigo airline logic
│ └── DBUtil.java # Database utility (CRUD operations)
├── Airline_DB.sql # SQL script for DB & tables
├── lib/ # JDBC driver (if required)
└── README.md # Documentation
