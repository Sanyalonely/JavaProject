package ex02;

import java.io.IOException;

/** * Інтерфейс "фабрикованих" об'єктів.
 * Оголошує методи для відображення результатів.
 */
public interface View {
    /** Відображає заголовок */
    void viewHeader();
    /** Відображає основну частину */
    void viewBody();
    /** Відображає закінчення */
    void viewFooter();
    /** Відображає об'єкт цілком */
    void viewShow();
    /** Виконує ініціалізацію даних */
    void viewInit();
    /** Зберігає дані для подальшого відновлення */
    void viewSave() throws IOException;
    /** Відновлює раніше збережені дані */
    void viewRestore() throws Exception;
}