//Joshua Baney
//CMSC330 Advanced Programming Languages 
//Project 1
// 2/2/25
// Text.java
// This file defines the Text class which displays a string on the scene.

import java.awt.*;

public class Text extends Image {
    private Point location;
    private String text;

    public Text(Color color, Point location, String text) {
        super(color);
        this.location = location;
        this.text = text;
    }

    @Override
    public void draw(Graphics graphics) {
        colorDrawing(graphics);
        graphics.drawString(text, location.x, location.y);
    }
}
