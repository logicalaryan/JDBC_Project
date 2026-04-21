# ✈️ Airline Management System

A **Java Swing + JDBC** desktop application that simulates a real-world airline management workflow. It allows administrators to register passengers, manage flights, book tickets, generate boarding passes, and handle cancellations — all backed by a **MySQL** relational database.

---

## 📋 Table of Contents
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Database Schema](#-database-schema)
- [Installation & Setup](#-installation--setup)
- [How to Run](#-how-to-run)
- [Sample Output](#-sample-output)
- [Future Improvements](#-future-improvements)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ Features

- 🔐 **Admin Login** — Secure credential-based login authenticated against the MySQL database
- 🏠 **Home Dashboard** — Intuitive menu-driven navigation (Air Indigo themed)
- 👤 **Customer Registration** — Add passenger details: name, nationality, Aadhar number, phone, address, and gender
- 🛫 **Flight Info** — Browse available flights with source, destination, and flight codes
- 🎟️ **Flight Booking** — Book a ticket by Aadhar lookup + flight route selection with travel date picker; auto-generates PNR & Ticket number
- 🗺️ **Journey Details** — View full reservation information for a booked passenger
- 🪪 **Boarding Pass** — Retrieve and display boarding pass details by PNR number
- ❌ **Cancellation** — Cancel a booking by PNR; records the cancellation and removes the reservation

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 8+ |
| GUI Framework | Java Swing / AWT |
| Database Connectivity | JDBC (`com.mysql.cj.jdbc.Driver`) |
| Database | MySQL |
| Date Picker | [JCalendar](https://toedter.com/jcalendar/) (`com.toedter.calendar.JDateChooser`) |
| IDE (recommended) | IntelliJ IDEA / Eclipse |

---

## 📂 Project Structure

```
JDBC_Project/
│
├── DbConnection.java       # JDBC connection helper (MySQL)
├── Login.java              # Admin login window
├── Home.java               # Main dashboard with menu navigation
├── Customer.java           # Passenger registration form
├── Flightinfo.java         # Flight details viewer
├── BookFlight.java         # Flight booking form
├── JourneyDetails.java     # Journey/reservation details viewer
├── Pass.java               # Boarding pass viewer
├── Cancellations.java      # Flight cancellation form
│
├── airline.sql             # MySQL database schema + seed data
│
├── plane_intro.jpg         # Home screen background image
├── customer.jpg            # Customer form image
├── flightbook.jpg          # Booking form image
├── cancel.jpg              # Cancellation form image
└── passs.jpeg              # Boarding pass image
```

---

## 🗄️ Database Schema

Run `airline.sql` to set up all required tables. Here is a summary:

| Table | Purpose |
|-------|---------|
| `login` | Admin credentials (`username`, `password`) |
| `passenger` | Registered passenger details |
| `flight` | Available flights with source & destination |
| `reservation` | Booking records with PNR & ticket numbers |
| `cancel` | Cancellation records |

**Pre-loaded flights:**

| Code | Flight | Route |
|------|--------|-------|
| 1001 | AI-1212 | Delhi → Mumbai |
| 1002 | AI-1453 | Delhi → Goa |
| 1003 | AI-1112 | Mumbai → Chennai |
| 1004 | AI-3222 | Delhi → Amritsar |
| 1005 | AI-1212 | Delhi → Ayodhya |

**Default admin credentials:** `admin` / `admin`

---

## ⚙️ Installation & Setup

### Prerequisites
- Java JDK 8 or higher
- MySQL Server 8.x
- MySQL JDBC Driver (`mysql-connector-j`)
- JCalendar library (`jcalendar-1.4.jar` or later)

---

### Step 1 — Clone the repository
```bash
git clone https://github.com/logicalaryan/JDBC_Project.git
cd JDBC_Project
```

### Step 2 — Create the MySQL database
```bash
mysql -u root -p < airline.sql
```
Or paste the contents of `airline.sql` into your MySQL client / Workbench.

### Step 3 — Update database credentials
Open `DbConnection.java` and update line 13 with your MySQL credentials:
```java
c = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/airlinemanagementsystem",
    "your_username",      // ← change this
    "your_password"       // ← change this
);
```

### Step 4 — Add required JAR files to the classpath
Download and add these JARs to your project's build path:
- [`mysql-connector-j-8.x.x.jar`](https://dev.mysql.com/downloads/connector/j/)
- [`jcalendar-1.4.jar`](https://toedter.com/jcalendar/)

**In IntelliJ IDEA:** `File → Project Structure → Libraries → + → Java → select the JAR`  
**In Eclipse:** Right-click project → `Build Path → Add External Archives`

### Step 5 — Organize images
Place all `.jpg` / `.jpeg` image files inside:
```
src/Logining/icon/
```
So that `ClassLoader.getSystemResource("Logining/icon/plane_intro.jpg")` resolves correctly.

---

## ▶️ How to Run

**From the IDE:**  
Run `Login.java` — this is the application entry point.

**From the command line** (after compiling):
```bash
javac -cp ".;mysql-connector-j.jar;jcalendar.jar" *.java
java  -cp ".;mysql-connector-j.jar;jcalendar.jar" Logining.Login
```
> On Linux/macOS replace `;` with `:` in the classpath.

---

## 🖥️ Sample Output

```
┌────────────────────────────────────┐
│   Username: admin                  │
│   Password: ••••••                 │
│  [ Reset ]  [ Submit ]  [ Close ]  │
└────────────────────────────────────┘
              ↓ (on successful login)

╔══════════════════════════════════════════════╗
║      AIR INDIGO WELCOMES YOU                 ║
║  Details ▼          Tickets ▼                ║
║   • Customer details  • Boarding pass        ║
║   • Flight details                           ║
║   • Reservation                              ║
║   • Journey                                  ║
║   • Cancellation                             ║
╚══════════════════════════════════════════════╝
```

**Booking flow:**
1. Open **Reservation** → enter Aadhar → click **Fetch User** (auto-fills name, nationality, address)
2. Select source & destination → click **Fetch Flight** (auto-fills flight code & name)
3. Pick travel date → click **Book Flight** → PNR and Ticket are auto-generated ✅

**Boarding Pass:**  
Enter PNR → click **ENTER** → passenger name, flight, route, and date are displayed.

---

## 🔮 Future Improvements

- 🌐 Expose functionality as a **REST API** using Spring Boot
- 🖥️ Build a **web-based UI** (React / Angular) to replace Swing
- 💳 Integrate **payment gateway** simulation for ticket purchase
- 📧 Send **email confirmation** on booking and cancellation
- 🔒 Replace plain-text passwords with **BCrypt hashing**
- 🛡️ Use **PreparedStatement** throughout to prevent SQL injection
- 📊 Add an **admin analytics dashboard** (revenue, seat occupancy, popular routes)
- 🐳 **Dockerize** the MySQL database for easier local setup
- 🧪 Add **JUnit** unit and integration tests

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. **Fork** the repository
2. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes with a meaningful message:
   ```bash
   git commit -m "feat: add seat selection module"
   ```
4. Push and open a **Pull Request** against `main`

Please keep code clean, avoid committing IDE-specific files, and update this README if you add new modules.

---

## 📄 License

This project is licensed under the **MIT License** — feel free to use, modify, and distribute it.

---

<div align="center">
  <b>Built with ☕ Java & ❤️ by <a href="https://github.com/logicalaryan">logicalaryan</a></b>
</div>
