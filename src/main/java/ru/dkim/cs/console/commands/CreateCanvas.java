package ru.dkim.cs.console.commands;

import com.google.common.base.Preconditions;
import ru.dkim.cs.drawing.CanvasFactory;
import ru.dkim.cs.drawing.DrawingContext;

/**
 * Creates canvas in commands context
 */
public class CreateCanvas implements DrawingCommand {
    private final DrawingContext drawingContext;
    private final int width;
    private final int height;

    public CreateCanvas(DrawingContext drawingContext, int width, int height) {
        Preconditions.checkArgument(drawingContext != null, "Context should not be null");
        Preconditions.checkArgument(width > 0, "width should be at least 1");
        Preconditions.checkArgument(height > 0, "height should be at least 1");

        this.drawingContext = drawingContext;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        drawingContext.setCanvas(CanvasFactory.createCanvas(width, height));
    }
}
