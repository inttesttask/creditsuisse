package ru.dkim.cs.console.commands;

import com.google.common.base.Preconditions;
import ru.dkim.cs.drawing.DrawingContext;

/**
 * Flushes canvas in commands context if canvas exists
 */
public class Flush implements DrawingCommand {
    private final DrawingContext drawingContext;

    public Flush(DrawingContext drawingContext) {
        Preconditions.checkArgument(drawingContext != null, "Context should not be null");

        this.drawingContext = drawingContext;
    }

    @Override
    public void draw() {
        this.drawingContext.flush();
    }
}
