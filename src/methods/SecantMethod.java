package methods;

public class SecantMethod extends Function {
	volatile double a;
	volatile double b;
	double c;
	double epsilon;
	int steps;
	int maxSteps = 1000;
	
	SecantMethod(double aa, double bb, double eps) {
		a = aa;
		b = bb;
		epsilon = eps;
		steps = 0;
		
		while(Math.abs(a-b) > epsilon && steps < maxSteps) {
			c = b - (f(b)*(b-a))/(f(b)-f(a));
			a = b;
			b = c;
			steps++;
		}
	}
	
	SecantMethod(double aa, double bb, double eps, int maxS) {
		a = aa;
		b = bb;
		epsilon = eps;
		steps = 0;
		maxSteps = maxS;
		
		while(Math.abs(a-b) > epsilon && steps < maxSteps) {
			c = b - (f(b)*(b-a))/(f(b)-f(a));
			a = b;
			b = c;
			steps++;
		}
	}
	
	public String toString() {
		return "Miejsce zerowe: " + c + ".\nDokładność " + String.format("%.3f", Math.abs(b-a)) + ".\nLiczba kroków "
				+ steps + ".\nFałszywy wynik " + falseResult() + ".\n\n";
	}
	
	String falseResult() {
		if(f(a) * f(b) < 0)
			return "nie";
		else
			return "tak";
	}
}
