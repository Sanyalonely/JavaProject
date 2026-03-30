package ex05;

import ex02.ViewResult;
import ex04.Command;
import java.util.concurrent.TimeUnit;

/**
 * Обчислення середнього значення паралельно.
 * @author Пилипенко
 */
public class AvgCommand implements Command {
    private double result = 0.0;
    private int progress = 0;
    private ViewResult viewResult;

    public AvgCommand(ViewResult viewResult) { this.viewResult = viewResult; }
    public boolean running() { return progress < 100; }

    @Override
    public void execute() {
        progress = 0;
        System.out.println("Average calculation started...");
        int size = viewResult.getItems().size();
        if (size == 0) { progress = 100; return; }

        for (int i = 0; i < size; i++) {
            result += viewResult.getItems().get(i).getEnergy();
            progress = (i * 100) / size;
            try { TimeUnit.MILLISECONDS.sleep(10); } catch (InterruptedException e) {} 
        }
        result /= size;
        System.out.println("Average done. Result = " + String.format("%.2f", result));
        progress = 100;
    }

    @Override
    public void undo() {} 
}