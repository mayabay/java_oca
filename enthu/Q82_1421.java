package enthu;

public class Q82_1421 {
	static final double percent = 9;						// if perecent is compile time constant, var value is tracked in flow
	int offset = 10, base = 50;

	public static double calc( double value ){
		int coupon, offset, base;

		if ( percent < 10 ){
			coupon = 15;
			offset = 20;
			base = 10;
		}
		return coupon * offset * base * value / 100;		// DNC 15: error: variable coupon might not have been initialized


	
	}


	public static void main(String[] args){
		System.out.println( calc(100) );

	}

}
