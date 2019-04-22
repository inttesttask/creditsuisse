package ru.dkim.cs.console.handlers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UnknownCommandHandlerTest {

    @Test
    void getDrawingCommand() {
        UnknownCommandHandler handler = new UnknownCommandHandler();
        assertThrows(IllegalArgumentException.class, () -> {
            handler.getDrawingCommand(null, new Scanner(new ByteArrayInputStream("\n".getBytes())));
        });
    }
}