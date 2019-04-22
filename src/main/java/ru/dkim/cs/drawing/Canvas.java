package ru.dkim.cs.drawing;

public interface Canvas {
    /**
     * paints "pixel"
     *
     * @param x     x coord
     * @param y     y coord
     * @param color pixel color. one character
     */
    void paint(int x, int y, String color);

    /**
     * @return string representing canvas
     */
    String getPrintableCanvas();

    /**
     * Flush the canvas
     */
    void flush();

    /**
     * @param x x coord
     * @param y y coord
     * @return current color of "pixel"
     */
    String getColor(int x, int y);

    /**
     * Checks whether x is in canvas
     *
     * @param x x coord (starting from 1)
     * @return true if x in canvas
     */
    boolean xInCanvas(int x);

    /**
     * Checks whether y is in canvas
     *
     * @param y y coord (starting from 1)
     * @return true if y in canvas
     */
    boolean yInCanvas(int y);
}
