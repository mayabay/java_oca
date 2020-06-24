package enthu;
class LoopTest1{

	public static void main(String[] args){
		//	do1();
		System.out.println( "factorial 6 = " + factorial(6) );

	}

	static int factorial(int n){
		System.out.println( "#" + n );

       	if(n==1) return 1;
      	else {
			int r = n*factorial(n-1);
			System.out.println( "\t r = " + r );

			return r;
		}  
   }

	static void do1(){
		int i = 1;
		while ( i++ < 2 ) System.out.println( i );

	}
}
