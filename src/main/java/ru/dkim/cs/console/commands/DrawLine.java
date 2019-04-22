package ru.dkim.cs.console.commands;

import com.google.common.base.Preconditions;
import ru.dkim.cs.Color;
import ru.dkim.cs.drawing.DrawingContext;

/**
 * Draw line in commands context
 */
public class DrawLine implements DrawingCommand {
    private final DrawingContext drawingContext;
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public DrawLine(DrawingContext drawingContext, int x1, int y1, int x2, int y2) {
        Preconditions.checkArgument(drawingContext != null, "Context should not be null");
        Preconditions.checkArgument(drawingContext.getCanvas().xInCanvas(x1), "x1 out of canvas limits");
        Preconditions.checkArgument(drawingContext.getCanvas().xInCanvas(x2), "x2 out of canvas limits");
        Preconditions.checkArgument(drawingContext.getCanvas().yInCanvas(y1), "y1 out of canvas limits");
        Preconditions.checkArgument(drawingContext.getCanvas().yInCanvas(y2), "y2 out of canvas limits");
        Preconditions.checkArgument(x1 == x2 || y1 == y2, "diagonal lines are not supported");

        this.drawingContext = drawingContext;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw() {
        if (x1 == x2) {//vertical line
            for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                this.drawingContext.getCanvas().paint(x1, y, Color.X.getC());
            }
        } else { //horizontal line
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                this.drawingContext.getCanvas().paint(x, y1, Color.X.getC());
            }
        }
    }
}
