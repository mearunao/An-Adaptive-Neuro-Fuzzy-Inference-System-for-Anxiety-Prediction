

import java.util.Random;

public class MF1 {
	
	public double a;
	
	public double b;
	
	//gradient a
	public double α;
	
	//gradient b
	public double β;
	
	public MF1(Random rand) {
		System.out.println(rand.nextGaussian());
		a = rand.nextGaussian()-1;
		b = rand.nextGaussian()-1 ;
	}

	public double compute(double x) {
		
		return 1.0 / (1 + Math.exp(b*(x-a)));
		
	}
}