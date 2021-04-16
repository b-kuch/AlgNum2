import Maths.BisectionInterval;
import Maths.Polynomial;

public class Main {

    static String format(double d) {
        return String.format("%.3f", d);
    }

    public static void main(String[] args) {

        System.out.println("Metoda bisekcji");
        BisectionInterval b = new BisectionInterval(-9, 1,
                new Polynomial(2021, 1, 0, 0, 0, 1));
        double length = b.length();
        double epsilon = 1.0 / 50 / 50;
        int i;
        for (i = 0; length > epsilon; i++) {
//            System.out.println("Iteracja nr " + i);
//            System.out.println(format(length) + " -- " + b);
//            System.out.println("x_0 ≈ c_" + i + " = " + format(b.getMiddle()) + "\n");
            length = b.trim();
        }
        System.out.println("Przybliżenie miejsca zerowego to " + format(b.getMiddle()));
        System.out.println("Błąd to " + length + " < epsilon = " + epsilon);
        System.out.println("Liczba iteracji to " + (i - 1));
    }
}