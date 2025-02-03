//Joshua Baney
//CMSC330 Advanced Programming Languages 
//Project 1
// 2/2/25
// Parser.java
// This file defines the parser for the project, updated to handle new image types.

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Parser {
    private JFrame window;
    private Token token;
    private Lexer lexer;

    public Parser(File file) throws IOException {
        lexer = new Lexer(file);
    }

    // scene → SCENE IDENTIFIER number_list images END '.'
    public Scene parseScene() throws LexicalError, SyntaxError, IOException {
        verifyNextToken(Token.SCENE);
        verifyNextToken(Token.IDENTIFIER);
        String windowName = lexer.getLexeme();
        int[] dimensions = getNumberList(2);
        Scene scene = new Scene(windowName, dimensions[0], dimensions[1]);
        parseImages(scene, lexer.getNextToken());
        verifyNextToken(Token.PERIOD);
        return scene;
    }

    // images → image images | image
    // image → right_triangle | rectangle | parallelogram | regular_polygon | isosceles | text
    private void parseImages(Scene scene, Token imageToken) throws LexicalError, SyntaxError, IOException {
        int height, width, offset, radius, sides;
        Color color;
        Point point, point2;

        // All image types start with a COLOR keyword.
        verifyNextToken(Token.COLOR);
        int[] colors = getNumberList(3);
        color = new Color(colors[0], colors[1], colors[2]);

        if (imageToken == Token.RIGHT_TRIANGLE) {
            // RIGHT_TRIANGLE COLOR number_list AT number_list HEIGHT NUMBER WIDTH NUMBER ';'
            verifyNextToken(Token.AT);
            int[] location = getNumberList(2);
            point = new Point(location[0], location[1]);
            verifyNextToken(Token.HEIGHT);
            verifyNextToken(Token.NUMBER);
            height = lexer.getNumber();
            verifyNextToken(Token.WIDTH);
            verifyNextToken(Token.NUMBER);
            width = lexer.getNumber();
            RightTriangle triangle = new RightTriangle(color, point, height, width);
            scene.addImage(triangle);
        } else if (imageToken == Token.RECTANGLE) {
            // RECTANGLE COLOR number_list AT number_list HEIGHT NUMBER WIDTH NUMBER ';'
            verifyNextToken(Token.AT);
            int[] location = getNumberList(2);
            point = new Point(location[0], location[1]);
            verifyNextToken(Token.HEIGHT);
            verifyNextToken(Token.NUMBER);
            height = lexer.getNumber();
            verifyNextToken(Token.WIDTH);
            verifyNextToken(Token.NUMBER);
            width = lexer.getNumber();
            Rectangle rectangle = new Rectangle(color, point, height, width);
            scene.addImage(rectangle);
        } else if (imageToken == Token.PARALLELOGRAM) {
            // PARALLELOGRAM COLOR number_list AT number_list number_list OFFSET NUMBER ';'
            verifyNextToken(Token.AT);
            int[] point1Nums = getNumberList(2);
            point = new Point(point1Nums[0], point1Nums[1]);
            int[] point2Nums = getNumberList(2);
            point2 = new Point(point2Nums[0], point2Nums[1]);
            verifyNextToken(Token.OFFSET);
            verifyNextToken(Token.NUMBER);
            offset = lexer.getNumber();
            Parallelogram parallelogram = new Parallelogram(color, point, point2, offset);
            scene.addImage(parallelogram);
        } else if (imageToken == Token.REGULAR_POLYGON) {
            // REGULAR_POLYGON COLOR number_list AT number_list SIDES NUMBER RADIUS NUMBER ';'
            verifyNextToken(Token.AT);
            int[] centerNums = getNumberList(2);
            point = new Point(centerNums[0], centerNums[1]);
            verifyNextToken(Token.SIDES);
            verifyNextToken(Token.NUMBER);
            sides = lexer.getNumber();
            verifyNextToken(Token.RADIUS);
            verifyNextToken(Token.NUMBER);
            radius = lexer.getNumber();
            RegularPolygon regPoly = new RegularPolygon(color, point, sides, radius);
            scene.addImage(regPoly);
        } else if (imageToken == Token.ISOSCELES) {
            // ISOSCELES COLOR number_list AT number_list HEIGHT NUMBER WIDTH NUMBER ';'
            verifyNextToken(Token.AT);
            int[] location = getNumberList(2);
            point = new Point(location[0], location[1]);
            verifyNextToken(Token.HEIGHT);
            verifyNextToken(Token.NUMBER);
            height = lexer.getNumber();
            verifyNextToken(Token.WIDTH);
            verifyNextToken(Token.NUMBER);
            width = lexer.getNumber();
            IsoscelesTriangle isoTriangle = new IsoscelesTriangle(color, point, height, width);
            scene.addImage(isoTriangle);
        } else if (imageToken == Token.TEXT) {
            // TEXT COLOR number_list AT number_list STRING ';'
            verifyNextToken(Token.AT);
            int[] location = getNumberList(2);
            point = new Point(location[0], location[1]);
            verifyNextToken(Token.STRING);
            String textStr = lexer.getLexeme();
            Text text = new Text(color, point, textStr);
            scene.addImage(text);
        } else {
            throw new SyntaxError(lexer.getLineNo(), "Unexpected image type: " + imageToken);
        }

        // End of the image; expect a semicolon.
        verifyNextToken(Token.SEMICOLON);
        token = lexer.getNextToken();
        if (token != Token.END)
            parseImages(scene, token);
        // (If token == END, it will be consumed later by parseScene.)
    }

    // number_list → '(' numbers ')'
    // numbers → NUMBER | NUMBER ',' numbers
    private int[] getNumberList(int count) throws LexicalError, SyntaxError, IOException {
        int[] list = new int[count];
        verifyNextToken(Token.LEFT_PAREN);
        for (int i = 0; i < count; i++) {
            verifyNextToken(Token.NUMBER);
            list[i] = lexer.getNumber();
            token = lexer.getNextToken();
            if (i < count - 1)
                verifyCurrentToken(Token.COMMA);
            else
                verifyCurrentToken(Token.RIGHT_PAREN);
        }
        return list;
    }

    // Returns a number list of unspecified length.
    private int[] getNumberList() throws LexicalError, SyntaxError, IOException {
        ArrayList<Integer> list = new ArrayList<>();
        verifyNextToken(Token.LEFT_PAREN);
        do {
            verifyNextToken(Token.NUMBER);
            list.add(lexer.getNumber());
            token = lexer.getNextToken();
        } while (token == Token.COMMA);
        verifyCurrentToken(Token.RIGHT_PAREN);
        int[] values = new int[list.size()];
        for (int i = 0; i < values.length; i++)
            values[i] = list.get(i);
        return values;
    }

    private void verifyNextToken(Token expectedToken) throws LexicalError, SyntaxError, IOException {
        token = lexer.getNextToken();
        verifyCurrentToken(expectedToken);
    }

    private void verifyCurrentToken(Token expectedToken) throws SyntaxError {
        if (token != expectedToken)
            throw new SyntaxError(lexer.getLineNo(), "Expecting token " + expectedToken + " not " + token);
    }
}
