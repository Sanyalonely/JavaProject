package ex01;

import java.io.Serializable;

/**
 * Клас для зберігання параметрів фізичного тіла та результатів обчислень.
 * Знаходить двійкове уявлення цілої частини значення кінетичної енергії.
 * Реалізує інтерфейс Serializable для можливості збереження стану об'єкта.
 * * @author Пилипенко
 * @version 3.0
 */
public class KineticEnergy implements Serializable {
    /** Автоматично згенерована константа для серіалізації */
    private static final long serialVersionUID = 1L;

    /** Маса фізичного тіла */
    private double mass;
    /** Швидкість фізичного тіла */
    private double velocity;
    /** Результат обчислення (кінетична енергія) */
    private double energy;

    /** Ініціалізує поля початковими (нульовими) значеннями */
    public KineticEnergy() {
        this.mass = 0.0;
        this.velocity = 0.0;
        this.energy = 0.0;
    }

    /**
     * Ініціалізує поля заданими значеннями.
     * * @param mass значення маси
     * @param velocity значення швидкості
     * @param energy значення енергії
     */
    public KineticEnergy(double mass, double velocity, double energy) {
        this.mass = mass;
        this.velocity = velocity;
        this.energy = energy;
    }

    /** @return Поточне значення маси */
    public double getMass() { return mass; }
    
    /** @param mass Нове значення маси */
    public void setMass(double mass) { this.mass = mass; }

    /** @return Поточне значення швидкості */
    public double getVelocity() { return velocity; }
    
    /** @param velocity Нове значення швидкості */
    public void setVelocity(double velocity) { this.velocity = velocity; }

    /** @return Поточне значення обчисленої енергії */
    public double getEnergy() { return energy; }
    
    /** @param energy Нове значення обчисленої енергії */
    public void setEnergy(double energy) { this.energy = energy; }

    /**
     * @return Двійкове уявлення цілої частини кінетичної енергії
     */
    public String getBinaryEnergy() { 
        return Integer.toBinaryString((int) energy); 
    }

    /**
     * Представляє результат обчислень у вигляді рядка.
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Маса: " + mass + ", Швидкість: " + velocity + 
               " -> Енергія: " + energy + " (Двійкове: " + getBinaryEnergy() + ")";
    }

    /**
     * Порівнює об'єкти на рівність.
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KineticEnergy other = (KineticEnergy) obj;
        return Double.compare(other.mass, mass) == 0 &&
               Double.compare(other.velocity, velocity) == 0 &&
               Double.compare(other.energy, energy) == 0;
    }
}
