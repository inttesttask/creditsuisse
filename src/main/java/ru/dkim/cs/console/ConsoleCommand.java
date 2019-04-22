package ru.dkim.cs.console;

public enum ConsoleCommand {
    CREATE_CANVAS("C"),
    DRAW_LINE("L"),
    DRAW_RECTANGLE("R"),
    BUCKET_FILL("B"),
    QUIT("Q"),
    FLUSH("F"),
    UNKNOWN("UNKNOWN");

    private String commandLineString;

    ConsoleCommand(String commandLineString) {
        this.commandLineString = commandLineString;
    }

    public static ConsoleCommand forName(String commandLineString) {
        for (ConsoleCommand consoleCommand : ConsoleCommand.values()) {
            if (consoleCommand.commandLineString.equals(commandLineString)) {
                return consoleCommand;
            }
        }
        return UNKNOWN;
    }
}
