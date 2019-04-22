package ru.dkim.cs.console.handlers;

import org.junit.jupiter.api.Test;
import ru.dkim.cs.console.commands.DrawingCommand;
import ru.dkim.cs.console.commands.Quit;

import static org.junit.jupiter.api.Assertions.*;

class QuitHandlerTest {

    @Test
    void getDrawingCommand() {
        QuitHandler handler = new QuitHandler();
        DrawingCommand drawingCommand = handler.getDrawingCommand(null, null);
        assertNotNull(drawingCommand);
        assertTrue(drawingCommand instanceof Quit);
    }
}