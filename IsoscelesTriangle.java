//Joshua Baney
//CMSC330 Advanced Programming Languages 
//Project 1
// 2/2/25
// IsoscelesTriangle.java
// This file defines the IsoscelesTriangle class representing an isosceles triangle.

import java.awt.*;

public class IsoscelesTriangle extends HollowPolygon {

    public IsoscelesTriangle(Color color, Point topVertex, int height, int width) {
        super(color, 3);
        int halfWidth = width / 2;
        // Define vertices: top vertex, bottom left, bottom right.
        int[] x_points = { topVertex.x, topVertex.x - halfWidth, topVertex.x + halfWidth };
        int[] y_points = { topVertex.y, topVertex.y + height, topVertex.y + height };
        createPolygon(x_points, y_points);
    }
}
