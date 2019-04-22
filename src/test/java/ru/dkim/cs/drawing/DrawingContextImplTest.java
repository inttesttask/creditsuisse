package ru.dkim.cs.drawing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DrawingContextImplTest {
    private DrawingContextImpl drawingContext;

    @BeforeEach
    void init() {
        drawingContext = new DrawingContextImpl();
    }

    @Test
    void createCanvasTest() {
        drawingContext.setCanvas(CanvasFactory.createCanvas(1, 1));
        assertTrue(drawingContext.getCanvas().xInCanvas(1));
        assertFalse(drawingContext.getCanvas().xInCanvas(2));
        assertTrue(drawingContext.getCanvas().yInCanvas(1));
        assertFalse(drawingContext.getCanvas().yInCanvas(2));
    }

    @Test
    void getCanvasTest() {
        assertThrows(IllegalStateException.class, () -> {
            drawingContext.getCanvas();
        });
        drawingContext.setCanvas(CanvasFactory.createCanvas(1, 1));
        String expectedCanvas = "---\n" +
                "| |\n" +
                "---\n";

        assertNotNull(drawingContext.getCanvas());
        assertEquals(expectedCanvas, drawingContext.getCanvas().getPrintableCanvas());
    }

    @Test
    void flushTest() {
        assertThrows(IllegalStateException.class, () -> {
            drawingContext.flush();
        });
        Canvas canvas = CanvasFactory.createCanvas(1, 1);
        canvas.paint(1, 1, "x");
        drawingContext.setCanvas(canvas);
        drawingContext.flush();
        String expectedCanvas = "---\n" +
                "| |\n" +
                "---\n";

        assertNotNull(drawingContext.getCanvas());
        assertEquals(expectedCanvas, drawingContext.getCanvas().getPrintableCanvas());
    }

    @Test
    void renderTest() {
        assertThrows(IllegalStateException.class, () -> {
            drawingContext.render();
        });

        drawingContext.setCanvas(CanvasFactory.createCanvas(1, 1));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedCanvas = "---\n" +
                "| |\n" +
                "---\n";
        drawingContext.render();
        assertNotNull(outContent);
        assertNotNull(outContent.toString());
        assertEquals(expectedCanvas.trim(), outContent.toString().trim());
    }
}