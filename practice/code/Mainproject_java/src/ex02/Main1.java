package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Головний клас для запуску програми з новим інтерфейсом. */
public class Main1 {
    /** Об'єкт, що реалізує інтерфейс View */
    private View view;

    /** Ініціалізує поле view через фабрику */
    public Main1(View view) {
        this.view = view;
    }

    /** Відображає меню та обробляє команди користувача */
    public void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Enter command...");
            System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
            try {
                s = in.readLine();
            } catch (IOException e) {
                System.out.println("Error: " + e);
                System.exit(0);
            }
            
            if (s.length() != 1) continue;

            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    view.viewShow(); 
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    view.viewInit();
                    view.viewShow();
                    break;
                case 's':
                    System.out.println("Save current.");
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    try {
                        view.viewRestore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                    break;
                default:
                    System.out.println("Wrong command.");
            }
        } while (s.charAt(0) != 'q');
    }

    public static void main(String[] args) {
        Main1 mainObj = new Main1(new ViewableResult().getView());
        mainObj.menu();
    }
}