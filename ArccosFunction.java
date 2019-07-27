import java.util.Scanner;

public class ArccosFunction {
	
	public static void main(String[] args) {
		ArccosFunction acrcosObj = new ArccosFunction();
		Scanner sc= new Scanner(System.in);
		System.out.println("pi value = " + acrcosObj.pi());
		System.out.println("Enter a value to calculate Arccos(x)...");
		double input=sc.nextDouble();		
		double ansInRad=acrcosObj.CalculateArccos(input);
		if(ansInRad==9999) {
			System.out.println("Invalid value");
		}
		else {
			System.out.println("Calculated value of Arccos(x) in radians...");
			System.out.printf("%.4f %n",ansInRad);		
			double ansInDeg=acrcosObj.convertToDegree(ansInRad);
			System.out.println("Calculated value of Arccos(x) in degrees...");
			System.out.printf("%.4f %n",ansInDeg);
		}
			
	}
	
	private double convertToDegree(double ansInRad) {
		double ansInDeg=ansInRad*(180/pi());
		return ansInDeg;
	}
	
	public double pi() {
		double value = 4;
		boolean flag = false;
		for (int i = 3; i < 999999; i += 2)
		{
		    if (flag)
		    {
		    	value += 4.0 / i;
		    }
		    else
		    {
		    	value -= 4.0 / i;
		    }
		    flag = !flag;
		 }
		return value;
	}
	
	private double calculatePower(double b, int pow) {
		double base = 1.0000;
		if (pow == 0) {
			base = 1;
		} else {
			for (int i = 1; i <= pow; i++) {
				base = b * base;
			}
		}
		return base;
	}

	private double calculateFactorial(int fact) {
		double val = 1.0;
		if (fact == 0) {
			val = 1;
		} else {
			for (int i = 1; i <= fact; i++) {
				val = val * i;
			}
		}
		return val;
	}
	
	public double CalculateArccos(double input) {
		if(input>1||input<-1) {
			return 9999;
		} else {
		double ans = 0;
		int i=0;
		while(i<99) {
			double fact1 = calculateFactorial(2 * i);			
			double pow1 = calculatePower(2, (2 * i));
			double pow2 = calculatePower(calculateFactorial(i), 2);			
			int exp = (2 * i) + 1;
			double b = calculatePower(input, exp) / exp;
			if (Double.isInfinite(fact1)) {
				break;
			}			
			ans = ans + ((fact1 / (pow1 * pow2)) * b);
			i++;
		}
		
		return ((pi() / 2) - ans);
		}
	}
}
