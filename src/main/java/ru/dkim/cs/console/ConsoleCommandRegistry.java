package ru.dkim.cs.console;

import ru.dkim.cs.console.handlers.ConsoleCommandHandler;

/**
 * Registry linking ConsoleCommand and ConsoleCommandHandler
 */
public interface ConsoleCommandRegistry {
    ConsoleCommandHandler getHandler(ConsoleCommand command);
}
