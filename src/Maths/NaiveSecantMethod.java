package Maths;

import java.util.Vector;

public class NaiveSecantMethod {
    private ClosedInterval interval;
    private Polynomial function;
    private Vector<Double> approximates;
    public NaiveSecantMethod(double a, double b, Polynomial function) {
        this.interval = new ClosedInterval(a, b);
        this.function = function;
        this.approximates = new Vector<Double>();
        approximates.add(this.interval.getLowerLimit());
        approximates.add(this.interval.getHigherLimit());
    }

    public double calculateNextApproximate() {
        double x_k_1 = approximates.elementAt(approximates.size()-2);
        double x_k = approximates.lastElement();
        double c = x_k
                - ( (function.valueAt(x_k) * (x_k - x_k_1))
                    / (function.valueAt(x_k)-function.valueAt(x_k_1)) );
        approximates.add(c);

        // updating the interval
        double f_a = function.valueAt(interval.getLowerLimit());
        double f_b = function.valueAt(interval.getHigherLimit());
        double f_c = function.valueAt(c);
        if (f_a*f_c<0) {
            interval.setHigherLimit(c);
        } else {
            interval.setLowerLimit(c);
        }
        return interval.length();
    }

    public double length() {
        return interval.length();
    }

    public double currentApproximate() {
        return approximates.lastElement();
    }
}
