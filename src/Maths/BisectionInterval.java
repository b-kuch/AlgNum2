package Maths;

public class BisectionInterval extends ClosedInterval {
    Polynomial function;

    public BisectionInterval(double lower, double higher, Polynomial function) {
        super(lower, higher);

        this.function = new Polynomial(function);

        // checking if f(a)*f(b)<=0
        double f_a = function.valueAt(getLowerLimit());
        double f_b = function.valueAt(getHigherLimit());
        try {
            if (f_a * f_b > 0) {
                throw new MathException("Both endpoints of the interval have common function value sign.");
            }
        } catch (MathException e) {
            System.err.println(e);
            System.exit(1);
        }
    }


    public double trim() {
        double f_a = function.valueAt(getLowerLimit());

        // f_b is not necessary since we checked the signs in the constructor
        //Fraction f_b = function.valueAt(getHigherLimit());
        double c = this.getMiddle();


        double f_c = function.valueAt(c);
        if (f_c == 0) {
            setLowerLimit(c);
            setHigherLimit(c);
        } else if (f_a * f_c < 0) {
            setHigherLimit(c);
        } else {
            setLowerLimit(c);
        }
        return getHigherLimit() - getLowerLimit();
    }

    public double getMiddle() {
        return (getLowerLimit() + getHigherLimit()) / 2;
    }
}
