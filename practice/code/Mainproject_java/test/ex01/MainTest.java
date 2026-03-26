package ex01;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Виконує тестування розроблених класів[cite: 505].
 * @author xone
 * @version 1.0
 */
public class MainTest {

    /** Перевірка коректності обчислень [cite: 128] */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        // m=2, v=3 => E=9 => bin="1001"
        calc.init(2.0, 3.0);
        assertEquals("1001", calc.getResult().getBinaryEnergy());
    }

    /** Перевірка серіалізації та transient полів [cite: 129] */
    @Test
    public void testRestore() {
        Calc calc = new Calc();
        double mass = 10.0;
        double vel = 2.0; // E=20 => bin="10100"
        
        calc.init(mass, vel);
        String expectedBin = calc.getResult().getBinaryEnergy();

        try {
            calc.save();
            calc.init(0, 0); // Скидаємо дані
            calc.restore();
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals(expectedBin, calc.getResult().getBinaryEnergy());
        assertEquals(mass, calc.getResult().getMass(), 1e-10);
        // Velocity має бути 0.0 після десеріалізації, бо вона transient [cite: 41, 103]
        assertEquals(0.0, calc.getResult().getVelocity(), 1e-10);
    }
}