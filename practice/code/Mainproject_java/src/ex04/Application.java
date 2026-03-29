package ex04;

import ex02.View;
import ex03.ViewableTable;

/**
 * Формує і відображає меню; реалізує шаблон Singleton.
 * @author Пилипенко
 */
public class Application {
    private static Application instance = new Application();
    private View view = new ViewableTable().getView();
    private Menu menu = new Menu();

    private Application() {}

    public static Application getInstance() {
        return instance;
    }

    public void run() {
        menu.add(new ChangeConsoleCommand(view));
        menu.execute();
    }
}