package ex03;

import ex02.ViewableResult;
import ex02.View;

/**
 * Concrete Creator.
 * Оголошує метод, що "фабрикує" об'єкти.
 * @author Пилипенко
 * @version 1.0
 */
public class ViewableTable extends ViewableResult {
    
    /** Створює відображуваний об'єкт ViewTable */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
