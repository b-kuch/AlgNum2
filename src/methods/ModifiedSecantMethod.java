package methods;

public class ModifiedSecantMethod extends Function {
	volatile double a;
	volatile double b;
	double c;
	double epsilon;
	int steps;
	int maxSteps = 1000;
	
	ModifiedSecantMethod(double aa, double bb, double eps) {
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
	
	ModifiedSecantMethod(double aa, double bb, double eps, int maxS) {
		a = aa;
		b = bb;
		epsilon = eps;
		steps = 0;
		maxSteps = maxS;
		
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
		return "Miejsce zerowe: " + c
				+ ".\nDokładność " + String.format("%.3f", Math.abs(b-a))
				+ ".\nLiczba kroków " + steps + "."
				+ stepLimit() + "\n\n";
	}
	
	String stepLimit() {
		if(steps == maxSteps)
			return "\nMetoda przekroczyła maksymalną liczbę kroków (" + maxSteps + ").";
		else
			return "";
	}
	
}
