# IoT-based Smart Parking Management System (IoT-SPMS)

A comprehensive smart parking solution tailored for the Ho Chi Minh City University of Technology (HCMUT) campus. This system leverages Internet of Things (IoT) technologies and modern software engineering principles to address traffic congestion, optimize parking capacity, and automate fee management.

---

## 🚀 Features

- **Real-time Monitoring:** Tracks parking slot occupancy using IoT sensor data to maintain a near real-time view of parking availability.
- **Automated Access Control:** Integrates with `HCMUT_SSO` and `HCMUT_DATACORE` to authenticate students, faculty, and staff via campus ID cards. Also supports temporary ticket issuance for external visitors.
- **Dynamic Guidance:** Electronic signage at gates and intersections directs traffic to available parking zones dynamically based on system data.
- **Automated Billing & Payment:** Calculates fees based on user roles and predefined billing cycles, integrating directly with the university's internal payment platform, **BKPay**.
- **Role-Based Access Control (RBAC):** Distinct dashboards, features, and permissions tailored for End Users (Learners/Staff), Parking Operators, and System Administrators.

---

## 🛠 Tech Stack

- **Frontend:** React.js (with React Router for navigation)
- **Backend:** Java Spring Boot, RESTful APIs
- **Database:** MySQL
- **IoT Infrastructure:** Sensors and Gateways (Data Simulation for testing)

---

# 🏁 Getting Started

Follow these step-by-step instructions to set up and run the project on your local environment.

---

## 1. Database Setup

1. Open your preferred MySQL management tool (e.g., MySQL Workbench, DBeaver, XAMPP).
2. Create a new empty database named `smart_parking`.
3. Import the initial database schema and mock data using the provided SQL script:

```bash
mysql -u <your_username> -p smart_parking < database_testing.sql
```

4. Update the backend connection settings:
   - Navigate to the file:

```bash
BE-SPS/src/main/resources/application.properties
```

5. Update the following properties to match your local MySQL credentials:

```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

## 2. Run Backend (Spring Boot)

Open a terminal instance and navigate to the backend directory:

```bash
cd BE-SPS
```

Compile and start the Spring Boot application using the Maven wrapper.

### On Windows (Command Prompt / PowerShell)

```bash
mvnw.cmd spring-boot:run
```

### On macOS / Linux

```bash
./mvnw spring-boot:run
```

After the build process finishes, the backend server will be available at:

```bash
http://localhost:8080
```

---

## 3. Run Frontend (React)

Open a new terminal instance and navigate to the frontend directory:

```bash
cd FE-SPS
```

Install all required Node.js dependencies:

```bash
npm install
```

Start the React development server:

```bash
npm start
```

The application will automatically open in your default web browser at:

```bash
http://localhost:5000
```
