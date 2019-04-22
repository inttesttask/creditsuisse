package ru.dkim.cs.console.commands;

import org.junit.jupiter.api.Test;
import ru.dkim.cs.drawing.DrawingContextImpl;
import ru.dkim.cs.drawing.DrawingContext;

import static org.junit.jupiter.api.Assertions.*;

class CreateCanvasTest {

    @Test
    void constructorValidationTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CreateCanvas(null, 1, 1);
        });

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreateCanvas(new DrawingContextImpl(), 0, 1);
        });
        assertEquals("width should be at least 1", exception.getMessage());

         exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreateCanvas(new DrawingContextImpl(), 1, 0);
        });
        assertEquals("height should be at least 1", exception.getMessage());
    }

    @Test
    void draw() {
        DrawingContext context = new DrawingContextImpl();
        CreateCanvas canvas = new CreateCanvas(context, 1, 1);
        canvas.draw();
        assertNotNull(context.getCanvas());
        assertTrue(context.getCanvas().xInCanvas(1));
        assertFalse(context.getCanvas().xInCanvas(2));
        assertTrue(context.getCanvas().yInCanvas(1));
        assertFalse(context.getCanvas().yInCanvas(2));
    }
}