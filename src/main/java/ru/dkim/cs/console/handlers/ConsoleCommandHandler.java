package ru.dkim.cs.console.handlers;

import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.drawing.DrawingContext;

import java.util.Scanner;

/**
 * Creates DrawingCommand and supplies it with command line parameters
 */
public interface ConsoleCommandHandler {
    DrawingCommand getDrawingCommand(DrawingContext drawingContext, Scanner argumentsScanner);
}
