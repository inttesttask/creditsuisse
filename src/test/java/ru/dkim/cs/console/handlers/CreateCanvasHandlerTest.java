package ru.dkim.cs.console.handlers;

import org.junit.jupiter.api.Test;
import ru.dkim.cs.console.commands.CreateCanvas;
import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.drawing.CanvasFactory;
import ru.dkim.cs.drawing.DrawingContextImpl;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateCanvasHandlerTest {

    @Test
    void getDrawingCommandTypeMatchTest() {
        CreateCanvasHandler handler = new CreateCanvasHandler();
        DrawingContextImpl drawingContext = new DrawingContextImpl();
        drawingContext.setCanvas(CanvasFactory.createCanvas(1, 1));

        DrawingCommand drawingCommand = handler.getDrawingCommand(drawingContext,
                new Scanner(new ByteArrayInputStream("1 1 1 1".getBytes())));
        assertNotNull(drawingCommand);
        assertTrue(drawingCommand instanceof CreateCanvas);
    }
}