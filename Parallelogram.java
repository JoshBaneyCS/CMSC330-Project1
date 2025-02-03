//Joshua Baney
//CMSC330 Advanced Programming Languages 
//Project 1
// 2/2/25
// Parallelogram.java
// This file defines the Parallelogram class representing a parallelogram shape.

import java.awt.*;

public class Parallelogram extends HollowPolygon {

    public Parallelogram(Color color, Point upperLeft, Point lowerRight, int offset) {
        super(color, 4);
        // Given an upper-left point (A) and lower-right point (C) plus an offset,
        // we define the four vertices as follows:
        // A = upperLeft
        // B = (lowerRight.x, upperLeft.y)
        // D = (upperLeft.x + offset, lowerRight.y)
        // C' = (lowerRight.x + offset, lowerRight.y)
        int[] x_points = {
            upperLeft.x,
            lowerRight.x,
            lowerRight.x + offset,
            upperLeft.x + offset
        };
        int[] y_points = {
            upperLeft.y,
            upperLeft.y,
            lowerRight.y,
            lowerRight.y
        };
        createPolygon(x_points, y_points);
    }
}
