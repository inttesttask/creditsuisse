package ru.dkim.cs.console.commands;

import com.google.common.base.Preconditions;
import ru.dkim.cs.drawing.DrawingContext;

/**
 * Draw rectangle in commands context
 */
public class DrawRectangle implements DrawingCommand {
    private final DrawingContext drawingContext;
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public DrawRectangle(DrawingContext drawingContext, int x1, int y1, int x2, int y2) {
        Preconditions.checkArgument(drawingContext != null, "Context should not be null");
        Preconditions.checkArgument(drawingContext.getCanvas().xInCanvas(x1), "x1 out of canvas limits");
        Preconditions.checkArgument(drawingContext.getCanvas().xInCanvas(x2), "x2 out of canvas limits");
        Preconditions.checkArgument(drawingContext.getCanvas().yInCanvas(y1), "y1 out of canvas limits");
        Preconditions.checkArgument(drawingContext.getCanvas().yInCanvas(y2), "y2 out of canvas limits");

        this.drawingContext = drawingContext;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw() {
        new DrawLine(drawingContext, x1, y1, x2, y1).draw();
        new DrawLine(drawingContext, x2, y1, x2, y2).draw();
        new DrawLine(drawingContext, x2, y2, x1, y2).draw();
        new DrawLine(drawingContext, x1, y2, x1, y1).draw();
    }
}
