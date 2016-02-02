package org.usfirst.frc2619;

public class MathUtil {
	
	public static double delinearize(double input, int power)
	{		
		return Math.pow(input, (double) power);
	}
	
	public static double deadbandCheck(double input, double db){
		
		if(Math.abs(input) < db){
			input = 0;
		}
		
		return input;
	}
}
