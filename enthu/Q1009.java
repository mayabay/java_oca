package enthu;
class Super1 {
	static String ID = "QBANK";
}
class Sub1 extends Super1{
	static {
		System.out.println( "In sub" );

	}
}
class Q1009 {

	public static void main(String[] args){
		System.out.println( Sub1.ID );

		System.out.println( '0' == 0 );

		System.out.println( (int)'0' );




	}
}
