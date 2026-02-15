# BigNatural

A Java program designed to handle very large natural numbers that exceed the limits of standard variables.

## Project Overview

The goal of this project is to manage "Big Naturals" (positive integers of any length). This allows the program to perform calculations that would normally cause errors or overflows in standard Java types like `int` or `long`.
1. **No Limits:** Numbers can be as long as the computer's memory allows.
2. **Basic Math:** Includes logic for adding and subtracting large numbers digit by digit.
3. **Comparing:** Can check if one large number is bigger, smaller, or equal to another.

The program takes large strings of numbers, converts them into a workable format, and performs the calculations.

## Key Features

* **Simple Storage:** Uses arrays or lists to store each digit of the number separately.
* **Math Logic:** Handles the "carry" when adding and the "borrow" when subtracting, just like doing math on paper.
* **Efficiency:** Designed to work quickly even with numbers containing hundreds of digits.
* **Safety:** Ensures results do not become negative, as these are natural numbers (starting from 0).

## Technologies Used

* **Language:** Java.
* **Standard:** Developed using Java SE standards.
* **External Library:** ACM Java Task Force (`acm.jar`).

## Dependencies

This project requires the **ACM Java Task Force** library (`acm.jar`) to handle input and output. 

## How to Run (Terminal)

1.  **Compile**:
    ```bash
    javac -cp ".:/path/to/your/acm.jar" Practica1.java
    ```
2.  **Run**:
    ```bash
    java -cp ".:/path/to/your/acm.jar" Practica1
    ```
*(Note: Replace `/path/to/your/acm.jar` with the actual location on your system. On Windows, use a semicolon `;` instead of a colon `:` in the command).*

## Technical Note (Language)
The internal comments and output console prints are written in **Catalan**, as it was an academic project for the University of Lleida (UdL) as part of the **Computer Science degree (Programació II, 2024-2025)**. This documentation is provided in English for universal portfolio visibility.

---
**Developed by:** Eric Buenavida Crespo.
