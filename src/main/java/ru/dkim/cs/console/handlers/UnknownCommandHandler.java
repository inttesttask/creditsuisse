package ru.dkim.cs.console.handlers;

import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.drawing.DrawingContext;

import java.util.Scanner;

public class UnknownCommandHandler implements ConsoleCommandHandler {
    private static final String USAGE = "Usage:\n" +
            "Command \t\tDescription\n" +
            "C w h           Creates a new canvas of width w and height h.\n" +
            "L x1 y1 x2 y2   Creates a new line from (x1,y1) to (x2,y2). Currently only\n" +
            "                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
            "                will be drawn using the 'x' character.\n" +
            "R x1 y1 x2 y2   Creates a new rectangle, whose upper left corner is (x1,y1) and\n" +
            "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
            "                using the 'x' character.\n" +
            "B x y c         Fills the entire area connected to (x,y) with \"color\" c. \n" +
            "Q               Quit the program.\n" +
            "F               Flushes the canvas";

    @Override
    public DrawingCommand getDrawingCommand(DrawingContext drawingContext, Scanner argumentsScanner) {
        //discard all parameters
        argumentsScanner.nextLine();
        throw new IllegalArgumentException("Unknown command \n" + USAGE);
    }
}
