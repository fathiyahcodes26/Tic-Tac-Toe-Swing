# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information

| Field          | Information            |
| -------------- | ---------------------- |
| **Name**       | Fathiyah Putri Riyanto |
| **Student ID** | 5026251XXX             |
| **Class**      | A                      |

---

# Project Description

This project is a simple Tic-Tac-Toe game developed using Java Swing as the graphical user interface. The application includes a login system connected to a PostgreSQL database, game statistics tracking, and a Top 5 leaderboard. The player uses the symbol **X** while the computer plays as **O**. After each game, the player's statistics are automatically updated and stored in the database.

---

# Features

* Login using PostgreSQL database
* Play Tic-Tac-Toe against a computer opponent
* Automatic detection of win, lose, and draw conditions
* Record player statistics (wins, losses, draws, and score)
* Score calculation:

  * Win = +10 points
  * Draw = +3 points
  * Lose = +0 points
* Display personal statistics
* Display Top 5 scorers using JTable
* Store all player data in a single PostgreSQL table

---

# Database

**Database Used:** PostgreSQL

---

## How to Create the Database

Open **pgAdmin** or the **psql terminal**, then execute the following commands:

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

Or simply execute the SQL file located in:

```text
database/schema.sql
```

---

# How to Run

1. Make sure PostgreSQL is running.
2. Create the database using the SQL script above.
3. Add the PostgreSQL JDBC Driver to your Java project.
4. Open `DatabaseManager.java`.
5. Configure the following values:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/game_project";
private static final String USER = "postgres";
private static final String PASSWORD = "your_password";
```

6. Compile and run `Main.java`.
7. Login using one of the available accounts.

Example:

Username: **student1**

Password: **12345**

---

# Class Explanation

| Class               | Responsibility                                                                                                         |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| **Main**            | Entry point of the application that opens the Login Window.                                                            |
| **DatabaseManager** | Manages JDBC connection to the PostgreSQL database.                                                                    |
| **Player**          | Model class that stores player information including username, wins, losses, draws, and score.                         |
| **PlayerService**   | Handles login authentication, updates player statistics, and retrieves the Top 5 scorers from the database.            |
| **GameLogic**       | Implements the Tic-Tac-Toe game rules including move validation, winner detection, draw detection, and computer moves. |
| **LoginFrame**      | Swing interface for user login using username and password.                                                            |
| **MainMenuFrame**   | Main menu displayed after successful login.                                                                            |
| **GameFrame**       | Swing window containing the Tic-Tac-Toe game board.                                                                    |
| **StatisticsFrame** | Displays the current player's statistics.                                                                              |
| **TopScorersFrame** | Displays the Top 5 players using JTable.                                                                               |

---

# Score Calculation

| Result | Score Change |
| ------ | ------------ |
| Win    | +10 points   |
| Draw   | +3 points    |
| Lose   | +0 points    |

---

# Screenshots

## Login

| Login   | Login Success | Login Failed | 
| ------- | ------------- | ------------ | 
|  | *image*       | *image*      | 

---

## Main Menu & Game

| Main Menu | Start Game |
| --------- | ---------- |
| *image*   | *image*    |

---

## Game Result

| Win     | Lose    | Draw    |
| ------- | ------- | ------- |
|         | *image* | *image* |

---

## Statistics & Leaderboard

| My Statistics | Top 5 Scorers |
| ------------- | ------------- |
| *image*       | <img width="607" height="485" alt="image" src="https://github.com/user-attachments/assets/c35bf584-e423-435a-83b1-0a6e35e984b1" />
      |

---

# GitHub Repository

https://github.com/fathiyahcodes26/Tictactoe

---

# YouTube Video

*(Insert your YouTube demonstration link here.)*
