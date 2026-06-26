# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information

| Field          | Information            |
| -------------- | ---------------------- |
| **Name**       | Fathiyah Putri Riyanto |
| **Student ID** | 5026251140             |
| **Class**      | A                      |

---

## Project Description

This project is a desktop-based Tic-Tac-Toe game developed using **Java Swing** as the graphical user interface and **PostgreSQL** as the database management system. The application provides a login system that authenticates users before accessing the game.

The player uses the **X** symbol while the computer automatically plays as **O**. During gameplay, the application validates player moves, detects winning combinations, checks draw conditions, and updates the game state accordingly.

The application also stores each player's game statistics, including wins, losses, draws, and total score. These statistics are automatically updated after every completed game and saved permanently in the PostgreSQL database. In addition, the application displays the player's personal statistics and a **Top 5 Scorers** leaderboard retrieved directly from the database.

This project demonstrates the implementation of Java Swing GUI programming, Object-Oriented Programming (OOP), JDBC database connectivity, SQL queries, and event-driven programming.

---

## Features

* Login using PostgreSQL database
* Play Tic-Tac-Toe against a computer opponent
* Automatic move validation
* Automatic winner detection
* Automatic draw detection
* Automatic computer moves
* Record player statistics (wins, losses, draws, and score)
* Score calculation:

  * Win = **+10** points
  * Draw = **+3** points
  * Lose = **+0** points
* Display personal statistics
* Display Top 5 Scorers using JTable
* Store all player data in a PostgreSQL database

---

## Database

**Database Management System:** PostgreSQL

### How to Create the Database

Execute the following SQL script using **pgAdmin** or the **psql terminal**:

```sql
CREATE DATABASE game_project;

CREATE TABLE players (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    wins INT DEFAULT 0,
    losses INT DEFAULT 0,
    draws INT DEFAULT 0,
    score INT DEFAULT 0
);

INSERT INTO players (username, password)
VALUES
('student1', '12345'),
('student2', '12345'),
('student3', '12345'),
('student4', '12345'),
('student5', '12345');
```

Alternatively, execute:

```text
database/schema.sql
```

---

## How to Run

1. Make sure PostgreSQL is running.
2. Create the database using the SQL script above.
3. Add the PostgreSQL JDBC Driver to the project.
4. Open `DatabaseManager.java`.
5. Configure the database connection.

```java
private static final String URL = "jdbc:postgresql://localhost:5433/game_project";
private static final String USER = "postgres";
private static final String PASSWORD = "your_password";
```

6. Run `Main.java`.
7. Login using one of the available accounts.

Example:

**Username:** `student1`

**Password:** `12345`

---

## Class Explanation

| Class               | Responsibility                                                                                                          |
| ------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| **Main**            | Starts the application by opening the Login window.                                                                     |
| **DatabaseManager** | Manages the JDBC connection to PostgreSQL.                                                                              |
| **Player**          | Represents player information such as username, password, wins, losses, draws, and score.                               |
| **PlayerService**   | Handles login authentication, retrieves player information, updates player statistics, and retrieves the Top 5 scorers. |
| **GameLogic**       | Implements the Tic-Tac-Toe game rules including move validation, winner detection, draw detection, and computer moves.  |
| **LoginFrame**      | Displays the login interface.                                                                                           |
| **MenuFrame**       | Displays the main menu after a successful login.                                                                        |
| **GameFrame**       | Displays the Tic-Tac-Toe game board and controls gameplay.                                                              |
| **StatisticsFrame** | Displays the logged-in player's statistics.                                                                             |
| **TopScorersFrame** | Displays the Top 5 players sorted by score using JTable.                                                                |

---

## Score Calculation

| Result   | Score Change |
| -------- | -----------: |
| **Win**  |   +10 points |
| **Draw** |    +3 points |
| **Lose** |    +0 points |

---

## Screenshots

### Login

|                                                  Login                                                  |                                              Login Success                                              |                                               Login Failed                                              |
| :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: |
| <img src="https://github.com/user-attachments/assets/931c2ea8-18a9-4e6e-9de3-5fccdf1024e7" width="250"> | <img src="https://github.com/user-attachments/assets/ab7f769a-2e2f-4bb2-a76a-caf4be49b786" width="250"> | <img src="https://github.com/user-attachments/assets/ecf23465-b130-406b-b3e3-be9344016878" width="250"> |

---

### Main Menu & Game

|                                                Main Menu                                                |                                                Start Game                                               |
| :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: |
| <img src="https://github.com/user-attachments/assets/d0a0164d-b0f7-4258-8044-5b6ddde4d688" width="300"> | <img src="https://github.com/user-attachments/assets/211b3d67-316c-47eb-a240-4bf7428e40d4" width="300"> |

---

### Game Result

|                                                   Win                                                   |                                                   Lose                                                  |                                                   Draw                                                  |
| :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: |
| <img src="https://github.com/user-attachments/assets/e1aefa6f-c9e2-45b7-9474-0b685fe0bc13" width="220"> | <img src="https://github.com/user-attachments/assets/a118be4a-d244-4be7-8a4d-752ba109f4b9" width="220"> | <img src="https://github.com/user-attachments/assets/4f099edf-ef3c-4cc7-a607-2b820810b3f5" width="220"> |

---

### Statistics & Leaderboard

|                                              My Statistics                                              |                                              Top 5 Scorers                                              |
| :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: |
| <img src="https://github.com/user-attachments/assets/3f056b05-0386-447b-8c5f-73ffbc67582d" width="300"> | <img src="https://github.com/user-attachments/assets/c35bf584-e423-435a-83b1-0a6e35e984b1" width="300"> |

---

## GitHub Repository

https://github.com/fathiyahcodes26/Tic-Tac-Toe-Swing

---

## YouTube Demonstration

*(Insert your YouTube demonstration link here after uploading the video.)*
