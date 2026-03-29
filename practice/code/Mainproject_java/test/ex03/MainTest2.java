package ex03;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

/**
 * Виконує тестування розроблених класів.
 * @author Пилипенко
 */
public class MainTest2 {

    @Test
    public void testCalc() {
        ViewTable tbl = new ViewTable(50, 5);
        assertEquals(50, tbl.getWidth());
        assertEquals(5, tbl.getItems().size());
        
        tbl.viewInit();
        assertFalse("Колекція не має бути порожньою", tbl.getItems().isEmpty());
    }

    @Test
    public void testRestore() {
        ViewTable tbl1 = new ViewTable(50, 10);
        ViewTable tbl2 = new ViewTable();

        tbl1.viewInit();

        try {
            tbl1.viewSave();
        } catch (IOException e) {
            fail("Помилка збереження: " + e.getMessage());
        }

        try {
            tbl2.viewRestore();
        } catch (Exception e) {
            fail("Помилка відновлення: " + e.getMessage());
        }

        assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
    }
}