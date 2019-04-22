package ru.dkim.cs.console.handlers;

import ru.dkim.cs.console.commands.DrawLine;
import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.drawing.DrawingContext;

import java.util.Scanner;

public class DrawLineHandler implements ConsoleCommandHandler {
    @Override
    public DrawingCommand getDrawingCommand(DrawingContext drawingContext, Scanner argumentsScanner) {
        return new DrawLine(drawingContext,
                argumentsScanner.nextInt(),
                argumentsScanner.nextInt(),
                argumentsScanner.nextInt(),
                argumentsScanner.nextInt());
    }
}
