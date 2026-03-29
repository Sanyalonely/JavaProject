package ex04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Макрокоманда. Колекція об'єктів ConsoleCommand.
 * @author Пилипенко
 */
public class Menu implements Command {
    private List<ConsoleCommand> menu = new ArrayList<>();
    private List<Command> history = new ArrayList<>();

    public ConsoleCommand add(ConsoleCommand command) {
        menu.add(command);
        return command;
    }

    @Override
    public void execute() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        menuLoop: while (true) {
            try {
                System.out.print("Enter command (");
                for (ConsoleCommand c : menu) {
                    System.out.print(c.toString() + ", ");
                }
                System.out.print("'z' undo, 'q' quit): ");
                
                s = in.readLine();
                if (s == null || s.length() == 0) continue;
                
                char key = s.charAt(0);
                if (key == 'q') {
                    System.out.println("Exit.");
                    break menuLoop;
                }
                if (key == 'z') {
                    undo();
                    continue menuLoop;
                }

                boolean found = false;
                for (ConsoleCommand c : menu) {
                    if (key == c.getKey()) {
                        c.execute();
                        history.add(c);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Wrong command.");
                }
            } catch (IOException e) {
                System.err.println("Error: " + e);
                System.exit(0);
            }
        }
    }

    @Override
    public void undo() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        Command lastCommand = history.remove(history.size() - 1);
        lastCommand.undo();
        System.out.println("Last action undone.");
    }
}