import Maths.BisectionInterval;
import Maths.NaiveSecantMethod;
import Maths.Polynomial;

public class Main {

    static String format(double d) {
        return String.format("%.3f", d);
    }
    public static void main(String[] args) {

        Polynomial function = new Polynomial(2021, 1, 0, 0, 0, 1);
        // setup
        double a = -9;
        double b = 1;
        double epsilon = 9;

        System.out.println("Metoda bisekcji");
        BisectionInterval bInterval = new BisectionInterval(a, b,
                function);
        double length = bInterval.length();

        int i;
        for (i = 0; length > epsilon; i++) {
//            System.out.println("Iteracja nr " + i);
//            System.out.println(format(length) + " -- " + bInterval);
//            System.out.println("x_0 ≈ c_" + i + " = " + format(bInterval.getMiddle()) + "\n");
            length = bInterval.trim();
        }
        System.out.println("Przybliżenie miejsca zerowego to " + format(bInterval.getMiddle()));
        System.out.println("Błąd to " + length + " < epsilon = " + epsilon);
        System.out.println("Liczba iteracji to " + (i - 1));


        System.out.println("\nMetoda siecznych");
        NaiveSecantMethod nSecant = new NaiveSecantMethod(a, b, function);
        length = nSecant.length();
        for (i = 0; length > epsilon; i++) {
//            System.out.println("Iteracja nr " + i);
//            System.out.println(format(length) + " -- " + bInterval);
//            System.out.println("x_0 ≈ c_" + i + " = " + format(bInterval.getMiddle()) + "\n");
            length = nSecant.calculateNextApproximate();
        }
        System.out.println("Przybliżenie miejsca zerowego to " + format(nSecant.currentApproximate()));
        System.out.println("Błąd to " + length + " < epsilon = " + epsilon);
        System.out.println("Liczba iteracji to " + (i - 1));



    }
}