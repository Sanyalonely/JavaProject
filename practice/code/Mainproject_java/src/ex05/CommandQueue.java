package ex05;

import ex04.Command;
import java.util.Vector;

/**
 * Обробник потоку (шаблон Worker Thread).
 * @author Пилипенко
 */
public class CommandQueue implements Queue {
    private Vector<Command> tasks = new Vector<>();
    private boolean waiting = false;
    private boolean shutdown = false;

    public CommandQueue() {
        new Thread(new Worker()).start();
    }

    public void shutdown() { 
        shutdown = true; 
    }

    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) { notifyAll(); }
        }
    }

    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try { wait(); } catch (InterruptedException ie) { waiting = false; }
            }
        }
        return tasks.remove(0);
    }

    private class Worker implements Runnable {
        public void run() {
            while (!shutdown) {
                Command r = take();
                r.execute();
            }
        }
    }
}