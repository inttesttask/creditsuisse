package ru.dkim.cs.drawing;

public interface DrawingContext {
    /**
     * Draws context
     */
    void render();

    /**
     * Flushes canvas if exists
     */
    void flush();

    /**
     * Sets new canvas to this context
     *
     * @param canvas canvas
     */
    void setCanvas(Canvas canvas);

    /**
     * returns Canvas if exists
     */
    Canvas getCanvas();
}
