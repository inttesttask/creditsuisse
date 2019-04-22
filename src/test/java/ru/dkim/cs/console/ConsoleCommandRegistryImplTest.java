package ru.dkim.cs.console;

import org.junit.jupiter.api.Test;
import ru.dkim.cs.console.handlers.*;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleCommandRegistryImplTest {
    private ConsoleCommandRegistryImpl commandRegistry = new ConsoleCommandRegistryImpl();

    @Test
    void getHandlerTest() {
        for (ConsoleCommand command : ConsoleCommand.values()) {
            ConsoleCommandHandler handler = commandRegistry.getHandler(command);
            assertNotNull(handler);
        }
        assertTrue(commandRegistry.getHandler(ConsoleCommand.CREATE_CANVAS) instanceof CreateCanvasHandler);
        assertTrue(commandRegistry.getHandler(ConsoleCommand.DRAW_LINE) instanceof DrawLineHandler);
        assertTrue(commandRegistry.getHandler(ConsoleCommand.DRAW_RECTANGLE) instanceof DrawRectangleHandler);
        assertTrue(commandRegistry.getHandler(ConsoleCommand.BUCKET_FILL) instanceof BucketFillHandler);
        assertTrue(commandRegistry.getHandler(ConsoleCommand.QUIT) instanceof QuitHandler);
        assertTrue(commandRegistry.getHandler(ConsoleCommand.FLUSH) instanceof FlushHandler);
        assertTrue(commandRegistry.getHandler(ConsoleCommand.UNKNOWN) instanceof UnknownCommandHandler);
    }
}