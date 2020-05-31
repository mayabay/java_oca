package hanu_11;
class InterestCalculator {
	public int yrs = 10;
	public static double rate = 0.1;
	public static String getClassName(){ return "InterestCalculator"; }

	double calculateInterest( double principle,  int yrs, double rate ){
		return principle * yrs * rate;
	}
}

class CompoundInterestCalculator {
	public int yrs = 20;
	public static double rate = 0.2;
	public static String getClassName(){ return "CompoundInterestCalculator"; }

	double calculateInterest( double principle,  int yrs, double rate ){
		return principle * Math.pow( 1+ rate, yrs ) - principle ;
	}
}
class PolyTest1 {
	
	public static void main(String[] args){
		
	}
}
