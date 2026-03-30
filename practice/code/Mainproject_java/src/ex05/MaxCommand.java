package ex05;

import ex02.ViewResult;
import ex04.Command;
import java.util.concurrent.TimeUnit;

/**
 * Пошук максимального значення паралельно.
 * @author Пилипенко
 */
public class MaxCommand implements Command {
    private double maxEnergy = 0.0;
    private int progress = 0;
    private ViewResult viewResult;

    public MaxCommand(ViewResult viewResult) { this.viewResult = viewResult; }
    public boolean running() { return progress < 100; }

    @Override
    public void execute() {
        progress = 0;
        System.out.println("Max search started...");
        int size = viewResult.getItems().size();
        if (size == 0) { progress = 100; return; }

        for (int i = 0; i < size; i++) {
            double current = viewResult.getItems().get(i).getEnergy();
            if (current > maxEnergy) {
                maxEnergy = current;
            }
            progress = (i * 100) / size;
            try { TimeUnit.MILLISECONDS.sleep(15); } catch (InterruptedException e) {} 
        }
        System.out.println("Max done. Max Energy = " + String.format("%.2f", maxEnergy));
        progress = 100;
    }

    @Override
    public void undo() {} 
}