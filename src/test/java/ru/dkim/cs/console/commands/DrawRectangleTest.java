package ru.dkim.cs.console.commands;

import org.junit.jupiter.api.Test;
import ru.dkim.cs.drawing.CanvasFactory;
import ru.dkim.cs.drawing.DrawingContextImpl;
import ru.dkim.cs.drawing.DrawingContext;

import static org.junit.jupiter.api.Assertions.*;

class DrawRectangleTest {
    @Test
    void constructorValidationTest() {
        assertThrows(IllegalStateException.class, () -> {
            new DrawRectangle(new DrawingContextImpl(), 1, 1, 1, 1);
        });

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawRectangle(null, 1, 1, 1, 1);
        });
        assertEquals("Context should not be null", exception.getMessage());

        DrawingContextImpl drawingContext = new DrawingContextImpl();
        drawingContext.setCanvas(CanvasFactory.createCanvas(2, 2));

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawRectangle(drawingContext, 0, 1, 1, 1);
        });
        assertEquals("x1 out of canvas limits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawRectangle(drawingContext, 1, 1, 0, 1);
        });
        assertEquals("x2 out of canvas limits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawRectangle(drawingContext, 1, 0, 1, 1);
        });
        assertEquals("y1 out of canvas limits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawRectangle(drawingContext, 1, 1, 1, 0);
        });
        assertEquals("y2 out of canvas limits", exception.getMessage());
        }
    
    @Test
    void drawRectangleTest() {
        DrawingContext drawingContext = new DrawingContextImpl();
        drawingContext.setCanvas(CanvasFactory.createCanvas(4, 4));
        DrawRectangle drawRectangle = new DrawRectangle(drawingContext, 1, 1, 3, 3);
        drawRectangle.draw();

        String expectedCanvas = "------\n" +
                "|xxx |\n" +
                "|x x |\n" +
                "|xxx |\n" +
                "|    |\n" +
                "------\n";

        assertEquals(expectedCanvas, drawingContext.getCanvas().getPrintableCanvas());
    }
}