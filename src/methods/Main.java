package methods;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		double a = 0, b = 0, eps = 0;
		boolean validData = false;
		Function F = new Function();
		Scanner in = new Scanner(System.in);
		while(validData == false) {
			System.out.print("Podaj lewy koniec przedziału: ");
			a = in.nextDouble();
			System.out.print("Podaj prawy koniec przedziału: ");
			b = in.nextDouble();
			System.out.print("Podaj dokładność: ");
			eps = in.nextDouble();
			if(F.f(a) * F.f(b) < 0 && eps > 0)
				validData = true;
			else
				System.out.println("Nieprawidłowe dane");
		}
		BisectionMethod bisection = new BisectionMethod(a, b, eps);
		SecantMethod secant = new SecantMethod(a, b, eps);
		ModifiedSecantMethod secantM = new ModifiedSecantMethod(a,b, eps);
		System.out.print("\nMetoda bisekcji:\n" + bisection);
		System.out.print("Metoda siecznych:\n" + secant);
		System.out.print("Metoda siecznych z wyborem:\n" + secantM);
		in.next();
		in.close();
	}

}
