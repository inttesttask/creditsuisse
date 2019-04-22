package ru.dkim.cs;

import ru.dkim.cs.console.ConsoleCommand;
import ru.dkim.cs.console.ConsoleCommandRegistry;
import ru.dkim.cs.console.ConsoleCommandRegistryImpl;
import ru.dkim.cs.drawing.DrawingContext;
import ru.dkim.cs.drawing.DrawingContextImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        //Initialize "beans"
        Scanner scanner = new Scanner(System.in);
        DrawingContext drawingContext = new DrawingContextImpl();
        ConsoleCommandRegistry consoleCommandRegistry = new ConsoleCommandRegistryImpl();

        //Main cycle
        ConsoleCommand consoleCommand = ConsoleCommand.UNKNOWN;
        while (consoleCommand != ConsoleCommand.QUIT) {
            try {
                System.out.print("enter command: ");
                consoleCommand = ConsoleCommand.forName(scanner.next());

                consoleCommandRegistry
                        .getHandler(consoleCommand)
                        .getDrawingCommand(drawingContext, scanner)
                        .draw();

                drawingContext.render();
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Wrong parameter type");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
