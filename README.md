
# File System Visitor Pattern

Assignment 6 — Software Design Patterns  
Astana IT University  
Java 17

## Project Description

This project demonstrates the Visitor behavioral design pattern
using a simple in-memory file system.

The file system contains files and nested directories.

Two visitors perform different operations:
- SizeCalculatorVisitor calculates the total size of files.
- SearchVisitor searches for files by a keyword.

## Design Pattern

The Visitor Pattern allows new operations to be added
without modifying existing element classes.

Double dispatch is implemented through accept() and visit().

## Main Components

- FileSystemElement — Element interface
- FileElement — Concrete Element
- DirectoryElement — Concrete Element
- FileSystemVisitor — Visitor interface
- SizeCalculatorVisitor — Concrete Visitor
- SearchVisitor — Concrete Visitor
- Main — Client

## Example Output

Total size: 1700 bytes

Matching files: [report.pdf, annual_report.docx]

## Testing

Eight JUnit 5 tests cover:
- File size calculation
- Nested directories
- Keyword search
- Case-insensitive search
- Empty search results
- Invalid file sizes and names
- Null directory children

## Clean Code

The report discusses principles from:
- Chapter 12 — Emergence
- Chapter 13 — Concurrency

## How to Run

1. Open the project in IntelliJ IDEA.
2. Select JDK 17.
3. Run Main.java.
4. Run FileSystemVisitorTest.java.

## UML

See file-system-visitor.puml.
