# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information

* **Name:** Fathiyah Putri Riyanto
* **Student ID:** [Your Student ID]
* **Class:** A
* **Course:** ES234211 – Programming Fundamental

---

## Project Description

This project is a Java Swing-based Tic-Tac-Toe game developed as an individual project for the Programming Fundamental course. The application integrates a graphical user interface (GUI), user authentication using a relational database, game logic, player statistics management, and a leaderboard that displays the Top 5 scorers.

The project applies fundamental programming concepts, including simple Object-Oriented Programming (OOP), Java Swing for GUI development, JDBC for database connectivity, and SQL for data storage and retrieval.

---

## Features

* User login with username and password authentication
* Interactive Tic-Tac-Toe game using Java Swing
* Automatic computer opponent
* Win, lose, and draw detection
* Player statistics (wins, losses, draws, and score)
* Top 5 leaderboard displayed using JTable
* Database integration using JDBC
* Navigation between Login, Main Menu, Game, Statistics, and Leaderboard windows

---

## Database

**Database Management System:** PostgreSQL

### Database Schema

```sql
CREATE TABLE players (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    wins INT DEFAULT 0,
    losses INT DEFAULT 0,
    draws INT DEFAULT 0,
    score INT DEFAULT 0
);
```

### Scoring System

| Result | Score |
| ------ | ----: |
| Win    |   +10 |
| Draw   |    +3 |
| Lose   |    +0 |

---

## How to Create the Database

1. Open PostgreSQL.
2. Create a database named:

```sql
CREATE DATABASE game_project;
```

3. Open the newly created database.
4. Execute the SQL statements in `database/schema.sql`.
5. Insert sample player data if necessary.

---

## How to Run the Program

### 1. Configure Database

Open:

```
DatabaseManager.java
```

Configure the connection:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/game_project";
private static final String USER = "postgres";
private static final String PASSWORD = "your_password";
```

---

### 2. Add PostgreSQL JDBC Driver

Add the PostgreSQL JDBC Driver to the project libraries.

---

### 3. Compile and Run

Run:

```
Main.java
```

The Login Window will appear.

---

### 4. Login

Use one of the existing accounts stored in the database.

Example:

```
Username : student1
Password : 12345
```

---

## Class Explanation

### Main.java

The entry point of the application. It initializes and displays the Login Window.

### DatabaseManager.java

Handles the JDBC connection to the PostgreSQL database.

### Player.java

Represents the player model containing player information such as username, wins, losses, draws, and score.

### PlayerService.java

Performs database operations including:

* User authentication
* Updating player statistics
* Retrieving Top 5 scorers

### GameLogic.java

Contains all game rules including:

* Board initialization
* Move validation
* Winner detection
* Draw detection
* Computer move generation

### LoginFrame.java

Provides the login interface and validates user credentials.

### MainMenuFrame.java

Displays the application's main menu and allows navigation to other windows.

### GameFrame.java

Contains the Tic-Tac-Toe game board and controls the gameplay.

### StatisticsFrame.java

Displays the current player's statistics retrieved from the database.

### TopScorersFrame.java

Displays the Top 5 players using a JTable sorted by score and number of wins.

---

## Screenshots

Add screenshots of the application here.

### Login Window

*(Insert login screenshot)*

### Main Menu

*(Insert main menu screenshot)*

### Game Window

*(Insert game screenshot)*

### Statistics Window

*(Insert statistics screenshot)*

### Top 5 Scorers Window

*(Insert leaderboard screenshot)*

---

## GitHub Repository

https://github.com/fathiyahcodes26/Tictactoe

---

## Video Demonstration

YouTube Link:

*(Insert YouTube URL here)*

---

## Technologies Used

* Java
* Java Swing
* PostgreSQL
* JDBC
* SQL
* Object-Oriented Programming (OOP)

---

## Project Structure

```
student-swing-game-project
│
├── src
│   ├── Main.java
│   ├── DatabaseManager.java
│   ├── Player.java
│   ├── PlayerService.java
│   ├── GameLogic.java
│   ├── LoginFrame.java
│   ├── MainMenuFrame.java
│   ├── GameFrame.java
│   ├── StatisticsFrame.java
│   └── TopScorersFrame.java
│
├── database
│   └── schema.sql
│
├── screenshots
│   ├── login-window.png
│   ├── game-window.png
│   ├── statistics-window.png
│   ├── game-window.png
│   └── top-scorers-window.png
│
└── README.md
```

---

## Conclusion

This project demonstrates the implementation of Java programming fundamentals through a complete desktop application. It integrates GUI development using Java Swing, database connectivity with JDBC, simple Object-Oriented Programming, SQL operations, and game logic implementation. The application fulfills the project requirements by providing login authentication, gameplay, statistics tracking, and a leaderboard using a single database table.
