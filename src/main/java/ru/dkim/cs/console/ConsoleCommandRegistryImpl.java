package ru.dkim.cs.console;

import ru.dkim.cs.console.handlers.*;

import java.util.HashMap;

public class ConsoleCommandRegistryImpl implements ConsoleCommandRegistry {
    private HashMap<ConsoleCommand, ConsoleCommandHandler> handlers = new HashMap<>();

    public ConsoleCommandRegistryImpl() {
        handlers.put(ConsoleCommand.CREATE_CANVAS, new CreateCanvasHandler());
        handlers.put(ConsoleCommand.DRAW_LINE, new DrawLineHandler());
        handlers.put(ConsoleCommand.DRAW_RECTANGLE, new DrawRectangleHandler());
        handlers.put(ConsoleCommand.BUCKET_FILL, new BucketFillHandler());
        handlers.put(ConsoleCommand.QUIT, new QuitHandler());
        handlers.put(ConsoleCommand.FLUSH, new FlushHandler());
        handlers.put(ConsoleCommand.UNKNOWN, new UnknownCommandHandler());
    }

    @Override
    public ConsoleCommandHandler getHandler(ConsoleCommand command) {
        return handlers.get(command);
    }
}
