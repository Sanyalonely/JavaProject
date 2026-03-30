package ex05;

import ex02.ViewResult;
import ex04.Command;
import java.util.concurrent.TimeUnit;

/**
 * Пошук мінімального значення паралельно.
 * @author Пилипенко
 */
public class MinCommand implements Command {
    private double minEnergy = Double.MAX_VALUE;
    private int progress = 0;
    private ViewResult viewResult;

    public MinCommand(ViewResult viewResult) { this.viewResult = viewResult; }
    public boolean running() { return progress < 100; }

    @Override
    public void execute() {
        progress = 0;
        System.out.println("Min search started...");
        int size = viewResult.getItems().size();
        if (size == 0) { progress = 100; return; }

        for (int i = 0; i < size; i++) {
            double current = viewResult.getItems().get(i).getEnergy();
            if (current < minEnergy) {
                minEnergy = current;
            }
            progress = (i * 100) / size;
            try { TimeUnit.MILLISECONDS.sleep(12); } catch (InterruptedException e) {} 
        }
        System.out.println("Min done. Min Energy = " + String.format("%.2f", minEnergy));
        progress = 100;
    }

    @Override
    public void undo() {} 
}