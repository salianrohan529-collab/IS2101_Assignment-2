# 🖥️ Interrupt Controller Simulation (Java)

## 📘 Overview
This project simulates an **Interrupt Controller** that handles multiple I/O device interrupts based on **priority** and **masking**.  
The simulation is implemented in Java using multithreading-like asynchronous simulation through random event triggering.

| Device   | Priority | Description |
|-----------|-----------|-------------|
| Keyboard | High | Highest priority |
| Mouse    | Medium | Medium priority |
| Printer  | Low | Lowest priority |

---

## ⚙️ Features
✅ Simulates **Keyboard**, **Mouse**, and **Printer** interrupts  
✅ Handles **priority-based ISR execution**  
✅ Supports **masking/unmasking** of devices  
✅ Maintains **execution log** with timestamps  
✅ Displays **real-time interrupt messages**  
✅ Simple, clean, and educational code for OS concepts  

---

## 🧠 Concepts Covered
- Interrupt Mechanism  
- Interrupt Service Routine (ISR)  
- Prioritization and Masking  
- Event Simulation and Logging  

---

## 🚀 How to Run

### 🧩 Online Compiler
1. Copy the `InterruptControllerSimulation.java` code into [JDoodle](https://www.jdoodle.com/) or [Replit](https://replit.com/).
2. Click **Run** to see the simulation output.

### 💻 Local Machine
```bash
javac InterruptControllerSimulation.java
java InterruptControllerSimulation
