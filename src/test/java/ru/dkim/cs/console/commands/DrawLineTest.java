package ru.dkim.cs.console.commands;

import org.junit.jupiter.api.Test;
import ru.dkim.cs.drawing.CanvasFactory;
import ru.dkim.cs.drawing.DrawingContextImpl;
import ru.dkim.cs.drawing.DrawingContext;

import static org.junit.jupiter.api.Assertions.*;

class DrawLineTest {
    @Test
    void constructorValidationTest() {
        assertThrows(IllegalStateException.class, () -> {
            new DrawLine(new DrawingContextImpl(), 1, 1, 1, 1);
        });

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawLine(null, 1, 1, 1, 1);
        });
        assertEquals("Context should not be null", exception.getMessage());

        DrawingContextImpl drawingContext = new DrawingContextImpl();
        drawingContext.setCanvas(CanvasFactory.createCanvas(2, 2));

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawLine(drawingContext, 0, 1, 1, 1);
        });
        assertEquals("x1 out of canvas limits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawLine(drawingContext, 1, 1, 0, 1);
        });
        assertEquals("x2 out of canvas limits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawLine(drawingContext, 1, 0, 1, 1);
        });
        assertEquals("y1 out of canvas limits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawLine(drawingContext, 1, 1, 1, 0);
        });
        assertEquals("y2 out of canvas limits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new DrawLine(drawingContext, 1, 1, 2, 2);
        });
        assertEquals("diagonal lines are not supported", exception.getMessage());
    }

    @Test
    void drawHorizontalTest() {
        DrawingContext drawingContext = new DrawingContextImpl();
        drawingContext.setCanvas(CanvasFactory.createCanvas(2, 2));
        DrawLine drawLine = new DrawLine(drawingContext, 1, 1, 2, 1);
        drawLine.draw();

        String expectedCanvas = "----\n" +
                "|xx|\n" +
                "|  |\n" +
                "----\n";

        assertEquals(expectedCanvas, drawingContext.getCanvas().getPrintableCanvas());
    }

    @Test
    void drawVerticalTest() {
        DrawingContext drawingContext = new DrawingContextImpl();
        drawingContext.setCanvas(CanvasFactory.createCanvas(2, 2));
        DrawLine drawLine = new DrawLine(drawingContext, 1, 1, 1, 2);
        drawLine.draw();

        String expectedCanvas = "----\n" +
                "|x |\n" +
                "|x |\n" +
                "----\n";

        assertEquals(expectedCanvas, drawingContext.getCanvas().getPrintableCanvas());
    }
}