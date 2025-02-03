//Joshua Baney
//CMSC330 Advanced Programming Languages 
//Project 1
// 2/2/25
// Token.java
// Enumerated type that defines the list of tokens

enum Token {
    AT, COLOR, END, HEIGHT, RECTANGLE, RIGHT_TRIANGLE, SCENE, WIDTH, COMMA, SEMICOLON, PERIOD, LEFT_PAREN,
    RIGHT_PAREN, IDENTIFIER, NUMBER, EOF,
    // New tokens for the extended grammar:
    PARALLELOGRAM, REGULAR_POLYGON, ISOSCELES, TEXT, SIDES, RADIUS, OFFSET, STRING
}
