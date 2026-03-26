package ex02;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

/**
 * Виконує тестування розроблених класів.
 * Перевіряє коректність збереження та відновлення колекції даних.
 * * @author Студент
 * @version 2.0
 */
public class MainTest1 {

    /** * Перевірка серіалізації. 
     * Тестує коректність відновлення даних з файлу. 
     */
    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult(10);
        ViewResult view2 = new ViewResult();

        view1.viewInit();

        try {
            view1.viewSave();
        } catch (IOException e) {
            fail("Помилка під час збереження даних: " + e.getMessage());
        }

        try {
            view2.viewRestore();
        } catch (Exception e) {
            fail("Помилка під час відновлення даних: " + e.getMessage());
        }

        assertEquals("Кількість збережених та відновлених елементів має збігатися", 
                     view1.getItems().size(), view2.getItems().size());
    }
}