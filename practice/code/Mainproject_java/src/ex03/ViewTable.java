package ex03;

import java.util.Formatter;
import ex01.KineticEnergy;
import ex02.ViewResult;

/**
 * Вивід у вигляді таблиці.
 * @author Пилипенко
 */
public class ViewTable extends ViewResult {
    /** Визначає ширину таблиці за замовчуванням */
    private static final int DEFAULT_WIDTH = 50;
    /** Поточна ширина таблиці */
    private int width;

    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    public ViewTable(int width) {
        this.width = width;
    }

    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    public int setWidth(int width) {
        return this.width = width;
    }

    public int getWidth() {
        return width;
    }

    private void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    private void outLineLn() {
        outLine();
        System.out.println();
    }

    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("|| %-10s | %-12s | %-15s ||\n", "Маса (кг)", "Швидкість", "Енергія (Дж)");
        System.out.print(fmt.toString());
        fmt.close();
    }

    private void outBody() {
        Formatter fmt = new Formatter();
        for (KineticEnergy item : getItems()) {
            fmt.format("|| %-10.2f | %-12.2f | %-15.2f ||\n", 
                       item.getMass(), item.getVelocity(), item.getEnergy());
        }
        System.out.print(fmt.toString());
        fmt.close();
    }

    /** * Перевантаження методу.*/
    public final void viewInit(int width) {
        this.width = width;
        viewInit();
    }

    public void viewInit() {
        System.out.print("Ініціалізація даних... ");
        super.viewInit();
        System.out.println("Готово.");
    }

    public void viewHeader() {
        outLineLn();
        outHeader();
        outLineLn();
    }

    public void viewBody() {
        outBody();
    }

    public void viewFooter() {
        outLineLn();
    }
}
