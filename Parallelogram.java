//Joshua Baney
//CMSC330 Advanced Programming Languages 
//Project 1
// 2/2/25
// Parallelogram.java
// This file defines the Parallelogram class representing a parallelogram shape.

import java.awt.*;

public class Parallelogram extends SolidPolygon {

    public Parallelogram(Color color, Point upperLeft, Point lowerRight, int offset) {
        // A parallelogram has 4 vertices.
        super(color, 4);
        // Given the upper left (A) and lower right (C) vertices, plus an offset,
        // we compute the vertices as follows:
        // A = upperLeft
        // B = (lowerRight.x, upperLeft.y)
        // C = (lowerRight.x + offset, lowerRight.y)
        // D = (upperLeft.x + offset, lowerRight.y)
        int[] x_points = {
            upperLeft.x,              // A.x
            lowerRight.x,             // B.x
            lowerRight.x + offset,    // C.x
            upperLeft.x + offset      // D.x
        };
        int[] y_points = {
            upperLeft.y,      // A.y
            upperLeft.y,      // B.y (same as A.y)
            lowerRight.y,     // C.y
            lowerRight.y      // D.y (same as C.y)
        };
        createPolygon(x_points, y_points);
    }
}