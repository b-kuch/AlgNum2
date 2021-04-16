package Maths;

public class ClosedInterval {
    private double lowerLimit;
    private double higherLimit;

    public ClosedInterval(double lowerLimit, double higherLimit) {
        try {
            if (higherLimit < lowerLimit) {
                throw new MathException("Interval range values are flipped, "
                        + lowerLimit + " is bigger than " + higherLimit + ".");
            }
        } catch (MathException e) {
            System.err.println(e);
            System.exit(1);
        }

        this.lowerLimit = lowerLimit;
        this.higherLimit = higherLimit;
    }

    public ClosedInterval(ClosedInterval closedInterval) {
        lowerLimit = closedInterval.lowerLimit;
        higherLimit = closedInterval.higherLimit;
    }

    @Override
    public String toString() {
        return "<" + String.format("%.3f", lowerLimit) + ", " + String.format("%.3f", higherLimit) + ">";
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double l) {
        lowerLimit = l;
    }

    public double getHigherLimit() {
        return higherLimit;
    }

    public void setHigherLimit(double h) {
        higherLimit = h;
    }

    public boolean hasIn(double f) {
        return f >= lowerLimit && f <= higherLimit;
    }

    public double length() {
        return higherLimit - lowerLimit;
    }

    public double getMiddle() {
        return (getLowerLimit() + getHigherLimit()) / 2;
    }
}

