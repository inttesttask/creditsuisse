package ru.dkim.cs.drawing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanvasImplTest {
    @Test
    void testConstructorException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CanvasFactory.createCanvas(-1, 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            CanvasFactory.createCanvas(1, 0);
        });
    }

    @Test
    void testCanvasCreationOK() {
        String expectedCanvas = "----\n" +
                "|  |\n" +
                "----\n";

        Canvas canvas = CanvasFactory.createCanvas(2, 1);
        assertEquals(expectedCanvas, canvas.getPrintableCanvas());
    }

    @Test
    void testXInCanvas() {
        Canvas canvas = CanvasFactory.createCanvas(2, 2);
        assertFalse(canvas.xInCanvas(0));
        assertFalse(canvas.xInCanvas(3));
        assertTrue(canvas.xInCanvas(2));
    }

    @Test
    void testYInCanvas() {
        Canvas canvas = CanvasFactory.createCanvas(3, 3);
        assertFalse(canvas.yInCanvas(0));
        assertFalse(canvas.yInCanvas(4));
        assertTrue(canvas.yInCanvas(3));
    }

    @Test
    void testPaintFailed() {
        Canvas canvas = CanvasFactory.createCanvas(1, 1);
        assertThrows(IllegalArgumentException.class, () -> {
            canvas.paint(2, 1, "c");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            canvas.paint(1, -2, "c");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            canvas.paint(1, 1, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            canvas.paint(1, 1, "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            canvas.paint(1, 1, "zz");
        });
    }

    @Test
    void testPaintOK() {
        Canvas canvas = CanvasFactory.createCanvas(2, 2);
        canvas.paint(1, 1, "c");

        String expectedCanvas = "----\n" +
                "|c |\n" +
                "|  |\n" +
                "----\n";

        assertEquals(expectedCanvas, canvas.getPrintableCanvas());
    }

    @Test
    void testFlushOK() {
        Canvas canvas = CanvasFactory.createCanvas(1, 1);
        canvas.paint(1, 1, "c");
        String expectedCanvasFilled = "---\n" +
                "|c|\n" +
                "---\n";
        String expectedCanvasFlushed = "---\n" +
                "| |\n" +
                "---\n";
        assertEquals(expectedCanvasFilled, canvas.getPrintableCanvas());
        canvas.flush();
        assertEquals(expectedCanvasFlushed, canvas.getPrintableCanvas());
    }
}