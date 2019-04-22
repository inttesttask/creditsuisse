package ru.dkim.cs.drawing;

public class CanvasFactory {
    public static Canvas createCanvas(int width, int height) {
        return new CanvasImpl(width, height);
    }
}
