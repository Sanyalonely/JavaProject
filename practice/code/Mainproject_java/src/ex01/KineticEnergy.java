package ex01;

import java.io.Serializable;

/**
 * Знаходить двійкове уявлення цілої частини значення кінетичної енергії.
 * Реалізує інтерфейс Serializable для можливості збереження стану об'єкта.
 * * @author Пилипенко
 */
public class KineticEnergy implements Serializable {
    private static final long serialVersionUID = 1L;

    private double mass;
    private double velocity;
    private double energy;

    public KineticEnergy() {
        this.mass = 0.0;
        this.velocity = 0.0;
        this.energy = 0.0;
    }

    public KineticEnergy(double mass, double velocity, double energy) {
        this.mass = mass;
        this.velocity = velocity;
        this.energy = energy;
    }

    public double getMass() { return mass; }
    public void setMass(double mass) { this.mass = mass; }
    public double getVelocity() { return velocity; }
    public void setVelocity(double velocity) { this.velocity = velocity; }
    public double getEnergy() { return energy; }
    public void setEnergy(double energy) { this.energy = energy; }

    /**
     * Двійкове уявлення цілої частини кінетичної енергії
     */
    public String getBinaryEnergy() { 
        return Integer.toBinaryString((int) energy); 
    }

    public String toString() {
        return "Маса: " + mass + ", Швидкість: " + velocity + 
               " -> Енергія: " + energy + " (Двійкове: " + getBinaryEnergy() + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KineticEnergy other = (KineticEnergy) obj;
        return Double.compare(other.mass, mass) == 0 &&
               Double.compare(other.velocity, velocity) == 0 &&
               Double.compare(other.energy, energy) == 0;
    }
}
