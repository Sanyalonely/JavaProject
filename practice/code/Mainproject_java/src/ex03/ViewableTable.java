package ex03;

import ex02.ViewableResult;
import ex02.View;

/**
 * Concrete Creator (шаблон проектування Factory Method).
 * Оголошує метод, що "фабрикує" об'єкти.
 * @author Пилипенко
 */
public class ViewableTable extends ViewableResult {
    
    /** Створює відображуваний об'єкт ViewTable */
    @Override
    public View getView() {
        return new ViewTable();
    }
}