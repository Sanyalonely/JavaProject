package ex04;

import ex02.View;
import ex02.ViewResult;
import java.io.*;
import java.util.Collections;
import java.util.List;

/**
 * Команда для зміни даних із можливістю відміни.
 * @author Пилипенко
 */
public class ChangeConsoleCommand implements ConsoleCommand {
    private View view;
    private byte[] backupState; 

    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'c';
    }

    @Override
    public String toString() {
        return "'c'hange";
    }

    @Override
    public void execute() {
        System.out.println("Change executed...");
        if (view instanceof ViewResult) {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(((ViewResult) view).getItems());
                backupState = baos.toByteArray();

                ViewResult viewResult = (ViewResult) view;
                Collections.reverse(viewResult.getItems());
                System.out.println("Table order reversed!");

            } catch (IOException e) {
                System.err.println("Помилка створення бекапу: " + e);
            }
        }
        view.viewShow();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void undo() {
        if (backupState != null && view instanceof ViewResult) {
            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(backupState);
                ObjectInputStream ois = new ObjectInputStream(bais);
                List items = (List) ois.readObject();
                
                ViewResult viewResult = (ViewResult) view;
                viewResult.getItems().clear();
                viewResult.getItems().addAll(items);
                
                System.out.println("Last action undone. Data reverted.");
                view.viewShow();

            } catch (Exception e) {
                System.err.println("Помилка скасування: " + e);
            }
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}
