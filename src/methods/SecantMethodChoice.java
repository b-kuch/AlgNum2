package methods;

public class SecantMethodChoice extends Function {
	volatile double a;
	volatile double b;
	double c;
	double epsilon;
	int steps;
	int maxSteps = 1000;
	
	SecantMethodChoice(double aa, double bb, double eps) {
		a = aa;
		b = bb;
		epsilon = eps;
		steps = 0;
		
		while(Math.abs(a-b) > epsilon && steps < maxSteps) {
			c = b - (f(b)*(b-a))/(f(b)-f(a));
			steps++;
			if(f(c) == 0) {
				break;
			}
			else if(f(b) * f(c) < 0){
				a = b;
				b = c;
			}
			else {
				b = c;
			}
		}
	}
	
	public String toString() {
		return "Miejsce zerowe: " + c + ".\nDokładność " + epsilon + ".\nLiczba kroków "
				+ steps + ".\nFałszywy pozytyw " + falseResult() + ".\n";
	}
	
	String falseResult() {
		if(f(a) * f(b) < 0)
			return "nie";
		else
			return "tak";
	}
}
