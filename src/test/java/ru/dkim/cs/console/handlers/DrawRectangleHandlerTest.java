package ru.dkim.cs.console.handlers;

import org.junit.jupiter.api.Test;
import ru.dkim.cs.console.commands.DrawRectangle;
import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.drawing.CanvasFactory;
import ru.dkim.cs.drawing.DrawingContextImpl;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DrawRectangleHandlerTest {

    @Test
    void getDrawingCommand() {
        DrawRectangleHandler handler = new DrawRectangleHandler();
        assertThrows(IllegalArgumentException.class, () -> {
            handler.getDrawingCommand(null, new Scanner(new ByteArrayInputStream("1 1 1 1".getBytes())));
        });

        DrawingContextImpl drawingContext = new DrawingContextImpl();
        drawingContext.setCanvas(CanvasFactory.createCanvas(1, 1));
        assertThrows(IllegalArgumentException.class, () -> {
            handler.getDrawingCommand(drawingContext, null);
        });

        DrawingCommand drawingCommand = handler.getDrawingCommand(drawingContext,
                new Scanner(new ByteArrayInputStream("1 1 1 1".getBytes())));
        assertNotNull(drawingCommand);
        assertTrue(drawingCommand instanceof DrawRectangle);
    }
}