// RegularPolygon.java
// Joshua Baney
// CMSC330 Advanced Programming Languages 
// Project 1
// 2/2/25
// RegularPolygon.java
// This file defines the RegularPolygon class representing a regular (solid) polygon.

import java.awt.*;

public class RegularPolygon extends SolidPolygon {

    public RegularPolygon(Color color, Point center, int sides, int radius) {
        super(color, sides);
        int[] x_points = new int[sides];
        int[] y_points = new int[sides];
        // Calculate vertices using trigonometry.
        // Start at an angle of -PI/2 to have a vertex at the top.
        double angleIncrement = 2 * Math.PI / sides;
        double startAngle = -Math.PI / 2;
        for (int i = 0; i < sides; i++) {
            double angle = startAngle + i * angleIncrement;
            x_points[i] = center.x + (int) Math.round(radius * Math.cos(angle));
            y_points[i] = center.y + (int) Math.round(radius * Math.sin(angle));
        }
        createPolygon(x_points, y_points);
    }
}
