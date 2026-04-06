package ex01;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Виконує тестування розроблених класів.
 * @author Пилипенко
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
        double vel = 2.0;
        
        calc.init(mass, vel);
        String expectedBin = calc.getResult().getBinaryEnergy();

        try {
            calc.save();
            calc.init(0, 0);
            calc.restore();
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals(expectedBin, calc.getResult().getBinaryEnergy());
        assertEquals(mass, calc.getResult().getMass(), 1e-10);
        assertEquals(0.0, calc.getResult().getVelocity(), 1e-10);
    }
}
