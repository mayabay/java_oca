package hanu_8;
class Exercises {
	
	public static void main(String[] args){

	}

	private static int add( int ... nrs ){
		int sum = 0;
		for ( int n : nrs ){
			sum += n;
		}
		return sum;
	}

	private static String concat( int ... nrs ){
		StringBuilder builder = new StringBuilder();
		for ( int n : nrs ){
			builder.append(n);
		}
		return builder.toStribuilder.toString();
	}



}
