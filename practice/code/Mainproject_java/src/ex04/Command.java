package ex04;

/**
 * Інтерфейс команди з можливістю скасування.
 * @author Пилипенко
 */
public interface Command {
    /** Виконання команди */
    void execute();
    /** Скасування команди */
    void undo();
}