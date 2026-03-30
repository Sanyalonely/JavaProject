package ex04;

import ex01.KineticEnergy;
import ex02.View;
import ex02.ViewResult;

/**
 * Команда для зміни даних із можливістю відміни.
 * @author Пилипенко
 */
public class ChangeConsoleCommand implements ConsoleCommand {
    private View view;
    private double lastOffset;

    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'c';
    }

    @Override
    public String toString() {
        return "'c' change";
    }

    @Override
    public void execute() {
        lastOffset = Math.random() * 100.0;
        System.out.println("Change item: add offset " + lastOffset);
        if (view instanceof ViewResult) {
            for (KineticEnergy item : ((ViewResult) view).getItems()) {
                item.setEnergy(item.getEnergy() + lastOffset);
            }
        }
        view.viewShow();
    }

    @Override
    public void undo() {
        System.out.println("Undo change: subtract offset " + lastOffset);
        if (view instanceof ViewResult) {
            for (KineticEnergy item : ((ViewResult) view).getItems()) {
                item.setEnergy(item.getEnergy() - lastOffset);
            }
        }
        view.viewShow();
    }
}