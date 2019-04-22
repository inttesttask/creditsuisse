package ru.dkim.cs.console.handlers;

import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.console.commands.Quit;
import ru.dkim.cs.drawing.DrawingContext;

import java.util.Scanner;

public class QuitHandler implements ConsoleCommandHandler {
    @Override
    public DrawingCommand getDrawingCommand(DrawingContext drawingContext, Scanner argumentsScanner) {
        return new Quit();
    }
}
