package ex04;

import static org.junit.Assert.*;
import org.junit.Test;
import ex01.KineticEnergy;
import ex02.ViewResult;

/** * Тестування функціональності команд та відміни (Undo).
 * @author Пилипенко
 */
public class MainTest3 {

    /**
     * Перевірка роботи команди Change та скасування її результату.
     */
    @Test
    public void testUndo() {
        ViewResult view = new ViewResult();
        view.viewInit();
        
        KineticEnergy item = view.getItems().get(0);
        double initialEnergy = item.getEnergy();
        
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(view);

        cmd.execute();
        assertNotEquals("Енергія повинна змінитися після execute", initialEnergy, item.getEnergy(), 1e-10);

        cmd.undo();
        assertEquals("Енергія повинна повернутися до початкового значення після undo", initialEnergy, item.getEnergy(), 1e-10);
    }
}