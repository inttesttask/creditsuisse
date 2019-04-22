package ru.dkim.cs.console.handlers;

import com.google.common.base.Preconditions;
import ru.dkim.cs.console.commands.DrawRectangle;
import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.drawing.DrawingContext;

import java.util.Scanner;

public class DrawRectangleHandler implements ConsoleCommandHandler {
    @Override
    public DrawingCommand getDrawingCommand(DrawingContext drawingContext, Scanner argumentsScanner) {
        Preconditions.checkArgument(argumentsScanner != null);

        return new DrawRectangle(drawingContext,
                argumentsScanner.nextInt(),
                argumentsScanner.nextInt(),
                argumentsScanner.nextInt(),
                argumentsScanner.nextInt());
    }
}
