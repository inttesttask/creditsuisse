package ru.dkim.cs.drawing;

public class DrawingContextImpl implements DrawingContext {
    private Canvas canvas;

    @Override
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void flush() {
        validateCanvas();
        canvas.flush();
    }

    @Override
    public Canvas getCanvas() {
        validateCanvas();
        return canvas;
    }

    @Override
    public void render() {
        validateCanvas();
        System.out.println(canvas.getPrintableCanvas());
    }

    private void validateCanvas() {
        if (canvas == null) {
            throw new IllegalStateException("You should create canvas first");
        }
    }
}
