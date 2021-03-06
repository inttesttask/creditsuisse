package ru.dkim.cs.console.handlers;

import ru.dkim.cs.console.commands.BucketFill;
import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.drawing.DrawingContext;

import java.util.Scanner;

public class BucketFillHandler implements ConsoleCommandHandler {
    @Override
    public DrawingCommand getDrawingCommand(DrawingContext drawingContext, Scanner argumentsScanner) {
        return new BucketFill(drawingContext,
                argumentsScanner.nextInt(),
                argumentsScanner.nextInt(),
                argumentsScanner.next());
    }
}
