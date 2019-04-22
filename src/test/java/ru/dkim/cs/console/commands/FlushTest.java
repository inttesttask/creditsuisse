package ru.dkim.cs.console.commands;

import org.junit.jupiter.api.Test;
import ru.dkim.cs.drawing.CanvasFactory;
import ru.dkim.cs.drawing.DrawingContextImpl;
import ru.dkim.cs.drawing.DrawingContext;

import static org.junit.jupiter.api.Assertions.*;

class FlushTest {
    @Test
    void constructorValidationTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Flush(null);
        });
        assertEquals("Context should not be null", exception.getMessage());
    }

    @Test
    void drawException() {
        assertThrows(IllegalStateException.class, () -> {
            new Flush(new DrawingContextImpl()).draw();
        });
    }

    @Test
    void drawFlushOK() {
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

        new Flush(drawingContext).draw();

        expectedCanvas = "------\n" +
                "|    |\n" +
                "|    |\n" +
                "|    |\n" +
                "|    |\n" +
                "------\n";

        assertEquals(expectedCanvas, drawingContext.getCanvas().getPrintableCanvas());
    }
}