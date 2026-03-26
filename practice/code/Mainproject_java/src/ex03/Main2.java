package ex03;

import ex02.View;
import ex02.Main1;

/**
 * Обчислення та відображення результатів у вигляді таблиці.
 * @author Студент
 * @version 4.0
 */
public class Main2 extends Main1 {

    public Main2(View view) {
        super(view);
    }

    public static void main(String[] args) {
        // Використовуємо нову фабрику для створення табличного відображення
        Main2 main = new Main2(new ViewableTable().getView());
        main.menu(); // Меню підтягнеться автоматично з ex02.Main1
    }
}