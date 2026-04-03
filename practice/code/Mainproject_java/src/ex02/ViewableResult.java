package ex02;

/**
 * Реалізує метод, що "фабрикує" об'єкти.
 */
public class ViewableResult implements Viewable {
    /** Створює відображуваний об'єкт ViewResult */
    public View getView() {
        return new ViewResult();
    }
}
