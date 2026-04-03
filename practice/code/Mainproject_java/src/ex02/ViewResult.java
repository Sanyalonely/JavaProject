package ex02;

import java.io.*;
import java.util.ArrayList;
import ex01.KineticEnergy;

/**
 * Обчислення функції, збереження та відображення результатів у колекції.
 */
public class ViewResult implements View {
    /** Ім'я файлу для серіалізації */
    private static final String FNAME = "items.bin";
    /** Кількість елементів за замовчуванням */
    private static final int DEFAULT_NUM = 10;
    /** Колекція для зберігання результатів */
    private ArrayList<KineticEnergy> items = new ArrayList<>();

    public ViewResult() {
        this(DEFAULT_NUM);
    }

    public ViewResult(int n) {
        for (int i = 0; i < n; i++) {
            items.add(new KineticEnergy());
        }
    }

    /** поточна колекція об'єктів */
    public ArrayList<KineticEnergy> getItems() {
        return items;
    }

    @Override
    public void viewInit() {
        double m = 5.0; 
        for (KineticEnergy item : items) {
            double v = Math.random() * 100.0;
            double energy = (m * v * v) / 2.0;
            item.setMass(m);
            item.setVelocity(v);
            item.setEnergy(energy);
        }
    }

    @Override
    public void viewSave() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(items);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME))) {
            items = (ArrayList<KineticEnergy>) is.readObject();
        }
    }

    @Override
    public void viewHeader() { 
        System.out.println("Результати обчислень:"); 
    }

    @Override
    public void viewBody() {
        for (KineticEnergy item : items) {
            System.out.println(item);
        }
    }

    @Override
    public void viewFooter() { 
        System.out.println("Кінець списку."); 
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
