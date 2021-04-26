package methods;

public class BisectionMethod extends Function {
	double a;
	double b;
	double c;
	double epsilon;
	int steps;
	int maxSteps = 1000;
	
	BisectionMethod(double aa, double bb, double eps) {	
		a = aa;
		b = bb;
		epsilon = eps;
		steps = 0;
		
		while(Math.abs(a-b) > epsilon && steps < maxSteps) {
			steps++;
			c = (a+b)/2;
			if(f(c) == 0) {
				break;
			}
			else if(f(a) * f(c) < 0){
				b = c;
			}
			else {
				a = c;
			}
		}
	}
	
	BisectionMethod(double aa, double bb, double eps, int maxS) {	
		a = aa;
		b = bb;
		epsilon = eps;
		steps = 0;
		maxSteps = maxS;
		
		while(Math.abs(a-b) > epsilon && steps < maxSteps) {
			steps++;
			c = (a+b)/2;
			if(f(c) == 0) {
				break;
			}
			else if(f(a) * f(c) < 0){
				b = c;
			}
			else {
				a = c;
			}
		}
	}
	
	public String toString() {
		return "Miejsce zerowe: " + c + ".\nDokładność " + String.format("%.5f", Math.abs(b-a)) + ".\nLiczba kroków " + steps + ".\n\n";
	}
}
