package ru.dkim.cs.drawing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CanvasFactoryTest {

    @Test
    void createCanvas() {
        Canvas canvas = CanvasFactory.createCanvas(1, 1);
        assertNotNull(canvas);
        assertTrue(canvas instanceof CanvasImpl);
    }
}