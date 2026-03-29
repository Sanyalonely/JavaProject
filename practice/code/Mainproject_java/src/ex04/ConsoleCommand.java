package ex04;

/**
 * Інтерфейс консольної команди.
 * @author Пилипенко
 */
public interface ConsoleCommand extends Command {
    /**
     * Повертає гарячу клавішу для виклику команди.
     * @return символ клавіші
     */
    char getKey();
}