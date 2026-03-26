package ex02;

/** * Concrete Creator.
 * Реалізує метод, що "фабрикує" об'єкти.
 */
public class ViewableResult implements Viewable {
    /** Створює відображуваний об'єкт ViewResult */
    @Override
    public View getView() {
        return new ViewResult();
    }
}