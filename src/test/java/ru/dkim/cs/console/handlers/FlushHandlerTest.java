package ru.dkim.cs.console.handlers;

import org.junit.jupiter.api.Test;
import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.console.commands.Flush;
import ru.dkim.cs.drawing.DrawingContextImpl;

import static org.junit.jupiter.api.Assertions.*;

class FlushHandlerTest {

    @Test
    void getDrawingCommand() {
        FlushHandler handler = new FlushHandler();
        assertThrows(IllegalArgumentException.class, () -> {
            handler.getDrawingCommand(null, null);
        });

        DrawingCommand drawingCommand = handler.getDrawingCommand(new DrawingContextImpl(), null);
        assertNotNull(drawingCommand);
        assertTrue(drawingCommand instanceof Flush);
    }
}