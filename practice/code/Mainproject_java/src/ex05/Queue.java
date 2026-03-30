package ex05;

import ex04.Command;

/**
 * Представляє чергу завдань для Worker Thread.
 * @author Пилипенко
 */
public interface Queue {
    void put(Command cmd);
    Command take();
}