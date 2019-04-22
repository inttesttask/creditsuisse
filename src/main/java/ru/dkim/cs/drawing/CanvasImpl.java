package ru.dkim.cs.drawing;

import com.google.common.base.Preconditions;
import ru.dkim.cs.Color;

public class CanvasImpl implements Canvas {
    private static final String VERTICAL_DIVIDER = "|";
    private static final String HORIZONTAL_DIVIDER = "-";

    private final int width;
    private final int height;
    private final String[] canvas;

    public CanvasImpl(int width, int height) {
        Preconditions.checkArgument(width > 0, "width should be at least 1");
        Preconditions.checkArgument(height > 0, "height should be at least 1");

        this.width = width;
        this.height = height;
        this.canvas = new String[width * height];
        flush();
    }

    @Override
    public void paint(int x, int y, String color) {
        Preconditions.checkArgument(xInCanvas(x), "x coord is out of canvas limits");
        Preconditions.checkArgument(yInCanvas(y), "y coord is out of canvas limits");
        Preconditions.checkArgument(color != null, "Invalid color");
        Preconditions.checkArgument(color.length() == 1, "Color should be 1 character");

        //Cause dev counts from 0 and normal people from 1
        this.canvas[(y - 1) * width + x - 1] = color;
    }

    @Override
    public String getPrintableCanvas() {
        StringBuilder stringBuilder = new StringBuilder();

        addHorizontalLine(stringBuilder);
        int i = 1;
        for (String point : canvas) {
            if (i == 1) { //Line start
                stringBuilder.append(VERTICAL_DIVIDER);
            }
            if (i == width) { //Line end
                stringBuilder.append(point).append(VERTICAL_DIVIDER).append("\n");
                i = 1;
            } else { //data
                stringBuilder.append(point);
                i++;
            }
        }
        addHorizontalLine(stringBuilder);

        return stringBuilder.toString();
    }

    @Override
    public void flush() {
        for (int i = 0; i < canvas.length; i++) {
            canvas[i] = Color.EMPTY.getC();
        }
    }

    @Override
    public String getColor(int x, int y) {
        Preconditions.checkArgument(xInCanvas(x), "x coord is out of canvas limits");
        Preconditions.checkArgument(yInCanvas(y), "y coord is out of canvas limits");

        //Cause dev counts from 0 and normal people from 1
        return this.canvas[(y - 1) * width + x - 1];
    }

    @Override
    public boolean xInCanvas(int x) {
        return x > 0 && x <= width;
    }

    @Override
    public boolean yInCanvas(int y) {
        return y > 0 && y <= height;
    }

    private void addHorizontalLine(StringBuilder builder) {
        int lineSize = this.width + (2 * VERTICAL_DIVIDER.length());
        for (int i = 0; i < lineSize; i++) {
            builder.append(HORIZONTAL_DIVIDER);
        }
        builder.append("\n");
    }
}
