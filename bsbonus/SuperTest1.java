package bsbonus;
import java.util.*;
class Super{
	static int do1(){ return 1; } ;
	int do2(){ return 11; }
}

class Sub extends Super{
	static int do1( ){ return 2; };
	int do2(){ return 22; }

	void test(){
		System.out.println("1: " + do1() );

		System.out.println("2: " + super.do1() );
	}

}
class SuperTest1 {
	
	static int[][] game;

	public final static void main(String[] args){
		Sub sub = new Sub();
		sub.test();

		String[] s = {"2", "22", "A", "b"};
		Arrays.sort( s );
		System.out.println( Arrays.toString( s ) );

		

		game[3][3] = 6;
		//game[1][1] = "x";


	}
}
