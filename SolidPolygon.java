//Joshua Baney
//CMSC330 Advanced Programming Languages 
//Project 1
// 2/2/25
// SolidPolygon.java
// This file defines the SolidPolygon class that draws a filled polygon.

import java.awt.*;

public class SolidPolygon extends Polygon_ {

    public SolidPolygon(Color color, int vertexCount) {
        super(color, vertexCount);
    }

    @Override
    public void drawPolygon(Graphics graphics, Polygon polygon) {
        graphics.fillPolygon(polygon);
    }
}
