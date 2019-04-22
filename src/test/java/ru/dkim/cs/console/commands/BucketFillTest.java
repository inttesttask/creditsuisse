package ru.dkim.cs.console.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.dkim.cs.drawing.CanvasFactory;
import ru.dkim.cs.drawing.DrawingContext;
import ru.dkim.cs.drawing.DrawingContextImpl;

import static org.junit.jupiter.api.Assertions.*;

class BucketFillTest {
    private DrawingContext drawingContext;

    @BeforeEach
    void initValidContext() {
        drawingContext = new DrawingContextImpl();
        drawingContext.setCanvas(CanvasFactory.createCanvas(3, 3));
    }

    @Test
    void constructorValidationContext() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BucketFill(null, 0, 0, null);
        });
        assertEquals("Context should not be null", exception.getMessage());
    }

    @Test
    void constructorValidationBadContext() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            new BucketFill(new DrawingContextImpl(), 0, 0, null);
        });
        assertEquals("You should create canvas first", exception.getMessage());
    }

    @Test
    void constructorValidationXbounds() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BucketFill(drawingContext, 0, 0, null);
        });
        assertEquals("x out of canvas limits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new BucketFill(drawingContext, 4, 1, null);
        });
        assertEquals("x out of canvas limits", exception.getMessage());
    }

    @Test
    void constructorValidationYbounds() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BucketFill(drawingContext, 1, 0, null);
        });
        assertEquals("y out of canvas limits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new BucketFill(drawingContext, 1, 4, null);
        });
        assertEquals("y out of canvas limits", exception.getMessage());
    }

    @Test
    void constructorValidationInvalidColor() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BucketFill(drawingContext, 1, 1, null);
        });
        assertEquals("Invalid color", exception.getMessage());
    }

    @Test
    void constructorValidationInvalidColorLength() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BucketFill(drawingContext, 1, 1, "XX");
        });
        assertEquals("Color should be 1 character", exception.getMessage());
    }

    @Test
    void constructorValidationInvalidColorEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BucketFill(drawingContext, 1, 1, " ");
        });
        assertEquals("Color should not be blank space", exception.getMessage());
    }

    @Test
    void drawSimpleTest() {
        BucketFill bucketFill = new BucketFill(drawingContext, 1, 1, "c");
        bucketFill.draw();

        String expectedCanvas = "-----\n" +
                "|ccc|\n" +
                "|ccc|\n" +
                "|ccc|\n" +
                "-----\n";

        assertEquals(expectedCanvas, drawingContext.getCanvas().getPrintableCanvas());
    }

    @Test
    void drawWithFiguresTest() {
        new DrawRectangle(drawingContext, 1,1,2,2).draw();
        new BucketFill(drawingContext, 3, 1, "c").draw();

        String expectedCanvas = "-----\n" +
                "|xxc|\n" +
                "|xxc|\n" +
                "|ccc|\n" +
                "-----\n";

        assertEquals(expectedCanvas, drawingContext.getCanvas().getPrintableCanvas());
    }

    @Test
    void drawWithFiguresTest2() {
        new DrawRectangle(drawingContext, 1,1,2,2).draw();
        new BucketFill(drawingContext, 1, 1, "c").draw();

        String expectedCanvas = "-----\n" +
                "|cc |\n" +
                "|cc |\n" +
                "|   |\n" +
                "-----\n";

        assertEquals(expectedCanvas, drawingContext.getCanvas().getPrintableCanvas());
    }
}