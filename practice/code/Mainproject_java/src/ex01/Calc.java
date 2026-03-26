package ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Клас для обчислення кінетичної енергії.
 * Зберігає та відновлює результати обчислень.
 * @author Пилипенко
 * @version 3.0
 */
public class Calc implements Serializable {
    /** Автоматично згенерована константа для серіалізації */
    private static final long serialVersionUID = 1L;
    /** Ім'я файлу для серіалізації */
    private static final String FNAME = "calc.bin";
    
    /** Об'єкт для зберігання параметрів та результату */
    private KineticEnergy result;

    /** Ініціалізує об'єкт результату */
    public Calc() {
        result = new KineticEnergy();
    }

    /** @param result об'єкт для встановлення результату */
    public void setResult(KineticEnergy result) {
        this.result = result;
    }

    /** @return поточний об'єкт результату */
    public KineticEnergy getResult() {
        return result;
    }

    /**
     * Обчислює кінетичну енергію та зберігає параметри в об'єкті.
     * @param mass маса тіла
     * @param velocity швидкість тіла
     */
    public void init(double mass, double velocity) {
        double energy = (mass * velocity * velocity) / 2.0;
        result.setMass(mass);
        result.setVelocity(velocity);
        result.setEnergy(energy);
    }

    /**
     * Виводить результат обчислень на екран.
     */
    public void show() {
        System.out.println(result.toString());
    }

    /**
     * Зберігає об'єкт у файл.
     * @throws IOException у разі помилки вводу-виводу
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    /**
     * Відновлює об'єкт з файлу.
     * @throws Exception у разі помилки читання або відсутності класу
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (KineticEnergy) is.readObject();
        is.close();
    }
}
