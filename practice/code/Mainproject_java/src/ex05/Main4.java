package ex05;

import ex02.View;
import ex03.ViewableTable; 
import ex04.Menu;
import ex04.ChangeConsoleCommand;
import ex04.GenerateConsoleCommand;
import ex04.ViewConsoleCommand;

/**
 * Головний клас для запуску 6-ї лабораторної роботи.
 * @author Пилипенко
 */
public class Main4 {
    public static void main(String[] args) {
        View view = new ViewableTable().getView();
        Menu menu = new Menu();

        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));

        menu.execute();
    }
}