# BigNatural - Large Number Arithmetic

A Java program designed to handle very large natural numbers that don't fit in normal variables.

## Project Overview

The goal of this project is to manage "Big Naturals" (positive integers of any length). This allows the program to do math that would normally cause errors in standard Java types like `int` or `long`.
1. **No Limits:** Numbers can be as long as the computer's memory allows.
2. **Basic Math:** Includes logic for adding and subtracting large numbers digit by digit.
3. **Comparing:** Can check if one large number is bigger, smaller, or equal to another.

The program takes large strings of numbers, turns them into a format it can work with, and performs the calculations.

## Key Features

* **Simple Storage:** Uses arrays or lists to store each digit of the number separately.
* **Math Logic:** Handles the "carry" when adding and the "borrow" when subtracting, just like doing math on paper.
* **Efficiency:** Designed to work quickly even with numbers that have hundreds of digits.
* **Safety:** Checks that you don't get negative results when subtracting, as these are natural numbers (starting from 0).

## Technologies Used

* **Language:** Java.
* **Standard:** Developed using Java SE standards.
* **Tools:** Can be run in any IDE like IntelliJ, Eclipse, or via the terminal.

## How to Run

1.  **Compile the program**:
    ```bash
    javac PRACTICA2.java
    ```
2.  **Run the utility**:
    ```bash
    java PRACTICA2
    ```

## Technical Note (Language)
The source code, variable names, and internal comments are written in **Catalan**, as it was an academic project for University of Lleida (Catalonia) as part of the **Computer Science degree (Programació II, 2024-2025)**. This documentation is provided in English so more people can understand the project.

---
**Developed by:** Eric Buenavida Crespo.
