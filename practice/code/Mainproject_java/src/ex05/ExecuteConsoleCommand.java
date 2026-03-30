package ex05;

import ex02.View;
import ex02.ViewResult;
import ex04.ConsoleCommand;
import java.util.concurrent.TimeUnit;

/**
 * Команда для одночасного запуску фонових потоків.
 * @author Пилипенко
 */
public class ExecuteConsoleCommand implements ConsoleCommand {
    private View view;

    public ExecuteConsoleCommand(View view) { this.view = view; }

    @Override public char getKey() { return 'e'; }
    @Override public String toString() { return "'e' execute threads"; }
    @Override public void undo() {}

    @Override
    public void execute() {
        CommandQueue queue1 = new CommandQueue();
        CommandQueue queue2 = new CommandQueue();

        MaxCommand maxCmd = new MaxCommand((ViewResult) view);
        AvgCommand avgCmd = new AvgCommand((ViewResult) view);

        System.out.println("Executing threads in parallel...");
        queue1.put(maxCmd);
        queue2.put(avgCmd);

        try {
            while (maxCmd.running() || avgCmd.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue1.shutdown();
            queue2.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("All threads finished.");
    }
}