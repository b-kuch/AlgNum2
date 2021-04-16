package Maths;

import java.util.Arrays;

/**
 * Represents a polynomial
 */
public class Polynomial {
    public static final Polynomial ZERO = new Polynomial(0.0);
    public static final Polynomial ONE = new Polynomial(1.0);
    private double[] coefficients; // coefficients from least important to most important coefficients

    /**
     * varargs constructor
     *
     * @param coeffs list of coefficients, sorted by degree in ascending order
     */
    public Polynomial(double... coeffs) {
        coefficients = Arrays.copyOf(coeffs, coeffs.length);
    }

    /**
     * copy constructor
     *
     * @param other copied polynomial
     */
    public Polynomial(Polynomial other) {
        coefficients = Arrays.copyOf(other.coefficients, other.coefficients.length);
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (int i = this.getDegree(); i >= 0; i--) {
            if (coefficients[i] == 0)
                continue;
            msg.append(coefficients[i]);
            if (i != 0) {
                msg.append("x");
                if (i != 1)
                    msg.append("^" + i);
                msg.append(" + ");
            }
        }
        return msg.toString();
    }


    int getDegree() {
        return coefficients.length - 1;
    }

    /**
     * Polynomial addition
     *
     * @param other A added Polynomial
     */
    public Polynomial add(Polynomial other) {
        Polynomial result = Polynomial.ZERO;
        result.coefficients = new double[Math.max(this.getDegree(), other.getDegree()) + 1];
        for (int i = 0; i <= result.getDegree(); i++) {
            result.coefficients[i] = this.coefficients[i] + other.coefficients[i];
        }
        return result;
    }

    /**
     * Polynomial multiplication
     *
     * @param other A polynomial by which is multiplied
     */
    public Polynomial multiply(Polynomial other) {
        Polynomial result = Polynomial.ZERO;
        result.coefficients = new double[this.getDegree() + other.getDegree() + 1];
        for (int i = 0; i <= result.getDegree(); i++) {
            result.coefficients[i] = 0.0;
        }
        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= other.getDegree(); j++) {
                result.coefficients[i + j] +=
                        this.coefficients[i] * (other.coefficients[j]);
            }
        }
        return result;
    }

    /**
     * Multiply polynomial by a fraction
     *
     * @param fr A fraction by which polynomial is multiplied
     */
    Polynomial multiply(double fr) {
        Polynomial result = new Polynomial(this);
        for (int i = 0; i <= result.getDegree(); i++) {
            result.coefficients[i] *= fr;
        }
        return result;
    }

    public double valueAt(double x) {
        double fx = 0;
        double temp;
        for (int i = 0; i <= this.getDegree(); i++) {
            temp = coefficients[i];
            for (int power = 0; power < i; power++) {
                temp *= x;
            }
            fx += temp;
        }
        return fx;
    }
}
