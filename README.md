# Project 1: Extending the Java Scene Parser

**Student Name:** [Your Name]  
**Course:** CMSC330 Advanced Programming Languages  
**Date:** [Insert Date]

---

## 1. Introduction

The objective of this project was to extend an existing Java program that parses a scene definition file to display various geometric images. Initially, the program supported only two image types—right triangles and rectangles. The project requirements expanded the grammar to include additional shapes such as parallelograms, regular polygons, isosceles triangles, and text objects.

Furthermore, a design decision was made to distinguish between filled (solid) shapes and outlined (hollow) shapes:
- **IsoscelesTriangle**, **Parallelogram**, and **RegularPolygon** are drawn as filled shapes by extending the **SolidPolygon** class.
- **RightTriangle** and **Rectangle** are drawn as outlines by extending the **HollowPolygon** class.

In addition to extending program functionality, an important goal of this project was to improve engineering documentation and deployment practices. Comprehensive documentation was prepared in a `README.md` file for GitHub, aligning the project with industry standards to streamline deployment and ensure maintainability.

---

## 2. Objectives and Goals

- **Extend the Scene Grammar:**  
  Modify the original grammar to support new tokens and image types, including parallelograms, regular polygons, isosceles triangles, and text objects.

- **Implement Advanced Token Handling:**  
  Update the `Token` enumeration and the `Lexer` to recognize new keywords and string literals, ensuring robust lexical analysis.

- **Update the Parser:**  
  Modify the parser to handle the new grammar rules and instantiate the appropriate objects based on the extended definitions.

- **Differentiate Rendering Styles:**  
  Introduce two base polygon classes:
  - **SolidPolygon** for filled shapes.
  - **HollowPolygon** for outlined shapes.

- **Develop New Image Classes:**  
  Implement new classes for:
  - **IsoscelesTriangle** (filled triangle),
  - **Parallelogram** (filled parallelogram),
  - **RegularPolygon** (filled regular polygon),
  - **Text** (to display strings).

- **Enhance Engineering Documentation and Deployment:**  
  Prepare comprehensive documentation in this README.md file on GitHub to support industry-standard project management and deployment practices.

- **Ensure Robust Testing:**  
  Create a comprehensive set of test cases to verify that the program correctly parses the scene file, handles errors gracefully, and displays the shapes as intended.

---

## 3. Project Breakdown

The project was divided into several key components:

1. **Requirement Analysis:**  
   - Reviewed the existing skeleton code.
   - Analyzed the expanded grammar and identified the new tokens and image types required.

2. **Lexer Enhancements:**  
   - Updated the `Token` enumeration to include new tokens.
   - Modified `Lexer.java` to correctly identify quoted strings and new keywords.

3. **Parser Modifications:**  
   - Extended the `parseImages` method in `Parser.java` to recognize and process additional image types.
   - Incorporated error handling for unexpected image types.

4. **Polygon Classes Design:**  
   - Implemented **SolidPolygon** for drawing filled polygons.
   - Ensured **HollowPolygon** continued to draw outlines.
   - Updated image classes to extend the appropriate base class:
     - **IsoscelesTriangle**, **Parallelogram**, and **RegularPolygon** extend **SolidPolygon**.
     - **RightTriangle** and **Rectangle** extend **HollowPolygon**.

5. **New Image Classes Implementation:**  
   - Created classes for **Text**, **IsoscelesTriangle**, **Parallelogram**, and **RegularPolygon**.
   - Developed appropriate constructors and drawing methods based on geometric computations.

6. **Testing and Debugging:**  
   - Developed multiple test cases covering all image types.
   - Debugged compilation and runtime issues to ensure proper integration of all classes.

7. **Documentation and Deployment:**  
   - Compiled this README.md file for comprehensive documentation.
   - Aligned the project with industry-standard deployment practices on GitHub.

---

## 4. Approach

### Lexer and Parser Updates

- **Lexer:**  
  The Lexer was updated to recognize string tokens by setting `tokenizer.quoteChar('"')` and handling `STRING` tokens. This ensures that text images are correctly parsed.

- **Parser:**  
  The Parser's `parseImages` method was expanded to support the additional image types. It now distinguishes between:
  - **Hollow shapes** (e.g., RightTriangle, Rectangle), and
  - **Solid shapes** (e.g., IsoscelesTriangle, Parallelogram, RegularPolygon).

### Polygon and Image Classes

- **HollowPolygon vs. SolidPolygon:**  
  - **HollowPolygon:** Uses `Graphics.drawPolygon()` to render outlines. Used by **RightTriangle** and **Rectangle**.
  - **SolidPolygon:** Uses `Graphics.fillPolygon()` to render filled shapes. Extended by **IsoscelesTriangle**, **Parallelogram**, and **RegularPolygon**.

- **New Image Classes:**  
  - **IsoscelesTriangle:** Computes vertices based on a top vertex, height, and width.
  - **Parallelogram:** Computes vertices using an upper-left point, a lower-right point, and an offset.
  - **RegularPolygon:** Uses trigonometry to calculate vertices for a filled regular polygon.
  - **Text:** Displays strings using `Graphics.drawString()`.

---

## 5. Test Plan

### Test Case 1: Original Image Types
- **Input File (scene1.txt):**
  ```plaintext
  Scene BasicTest (500, 500)
    RightTriangle Color (255, 0, 0) at (50, 30) Height 100 Width 300;
    Rectangle Color (0, 128, 255) at (100, 100) Height 200 Width 100;
  End.

## 6. Lessons Learned and Potential Improvements

### Lessons Learned
- **Extending Grammars:**  
  Modifying an existing parser to support new tokens and rules deepened my understanding of lexical analysis and grammar design.

- **Modular Design with Inheritance:**  
  Differentiating between filled and outlined shapes by using separate base classes (SolidPolygon vs. HollowPolygon) simplified the implementation and made future extensions more manageable.

- **Geometric Computations:**  
  Calculating vertices for various shapes—especially those requiring trigonometry—reinforced the importance of precision in geometric programming.

- **Incremental Testing:**  
  Systematic testing of each new feature was crucial in identifying and resolving integration issues early in the development process.

- **Engineering Documentation and Deployment:**  
  Preparing a comprehensive README.md for GitHub improved project organization and aligned the project with industry practices, enhancing maintainability and ease of deployment.

### Potential Improvements
- **Error Recovery:**  
  Implement improved error recovery in the parser to allow multiple syntax errors to be reported rather than stopping at the first error.

- **Utility Classes for Geometry:**  
  Create utility classes to handle common geometric calculations, reducing code duplication and improving maintainability.

- **Enhanced UI Features:**  
  Add features like interactive editing, zooming, or dynamic resizing of the drawing panel to improve usability.

- **Automated Testing:**  
  Develop a suite of unit tests for both the parser and the drawing logic to further ensure the robustness of the application.

---

## 7. Conclusion

This project successfully extended the original Java scene parser to support a richer set of geometric shapes and text objects. By updating the grammar and modifying both the Lexer and Parser, the program now creates a scene that includes both hollow and solid images. The design decision to use **SolidPolygon** for filled shapes (IsoscelesTriangle, Parallelogram, RegularPolygon) and **HollowPolygon** for outlined shapes (RightTriangle, Rectangle) provided clear modularity and improved maintainability.

Additionally, enhancing the engineering documentation through this README.md and aligning deployment practices with industry standards has prepared the project for future professional use. Overall, this project has significantly enhanced my understanding of parsing, object-oriented design, and graphical programming in Java.

## 7. Conclusion


No License, but this is for Project 1 for CMSC 330 at UMGC Spring 2025. 
