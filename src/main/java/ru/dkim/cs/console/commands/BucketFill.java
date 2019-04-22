package ru.dkim.cs.console.commands;

import com.google.common.base.Preconditions;
import ru.dkim.cs.Color;
import ru.dkim.cs.drawing.Canvas;
import ru.dkim.cs.drawing.DrawingContext;

/**
 * Fills space in commands context
 */
public class BucketFill implements DrawingCommand {
    private final DrawingContext drawingContext;
    private final int x;
    private final int y;
    private final String color;
    private String prevColor;

    public BucketFill(DrawingContext drawingContext, int x, int y, String color) {
        Preconditions.checkArgument(drawingContext != null, "Context should not be null");
        Preconditions.checkArgument(drawingContext.getCanvas().xInCanvas(x), "x out of canvas limits");
        Preconditions.checkArgument(drawingContext.getCanvas().yInCanvas(y), "y out of canvas limits");
        Preconditions.checkArgument(color != null, "Invalid color");
        Preconditions.checkArgument(color.length() == 1, "Color should be 1 character");
        Preconditions.checkArgument(!Color.EMPTY.getC().equals(color), "Color should not be blank space");

        this.drawingContext = drawingContext;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void draw() {
        prevColor = drawingContext.getCanvas().getColor(x, y);
        if (!color.equals(prevColor)) {
            fill(x, y);
        }
    }

    private void fill(int x, int y) {
        Canvas canvas = drawingContext.getCanvas();
        if (canvas.xInCanvas(x)
                && canvas.yInCanvas(y)
                && prevColor.equals(canvas.getColor(x, y))) {
            canvas.paint(x, y, color);

            fill(x - 1, y);
            fill(x + 1, y);
            fill(x, y - 1);
            fill(x, y + 1);
        }
    }
}
